#!/usr/bin/env python3
import argparse
import csv
import pathlib
import sys


def main():
    parser = argparse.ArgumentParser(description='Check JaCoCo branch coverage for selected classes')
    parser.add_argument('--repo-root', default='.', help='Repo root (default: .)')
    parser.add_argument('--csv', default='algorithm/target/site/jacoco/jacoco.csv')
    parser.add_argument('--classes', nargs='+', required=True, help='Fully qualified class names or simple class names')
    args = parser.parse_args()

    csv_path = pathlib.Path(args.repo_root) / args.csv
    if not csv_path.exists():
        print(f'jacoco.csv not found at {csv_path}', file=sys.stderr)
        sys.exit(2)

    wanted = set(args.classes)
    misses = []

    with csv_path.open() as f:
        reader = csv.DictReader(f)
        for r in reader:
            cls = r['CLASS']
            fqcn = f"{r['PACKAGE']}.{cls}"
            if cls in wanted or fqcn in wanted:
                mb = int(r['BRANCH_MISSED'])
                cb = int(r['BRANCH_COVERED'])
                if mb > 0:
                    misses.append((fqcn, mb, cb))

    if misses:
        for fqcn, mb, cb in misses:
            print(f'{fqcn}: BRANCH_MISSED={mb}, BRANCH_COVERED={cb}')
        sys.exit(1)


if __name__ == '__main__':
    main()
