---
name: leet-flow
description: Standardize LeetCode solution additions with JavaDoc, tests, and README index updates for global and LCR packages.
---

# leet-flow

Use this skill when adding a new LeetCode solution in this repo.

## Priority Keywords

- `MUST`: required for completion.
- `SHOULD`: strongly recommended unless blocked.
- `MAY`: optional improvement.

## Scope

- Global code: `algorithm/src/main/java/org/example/leetcode/global`
- LCR code: `algorithm/src/main/java/org/example/leetcode/lcr`
- Tests: `algorithm/src/test/java/org/example/leetcode/global` and `algorithm/src/test/java/org/example/leetcode/lcr`
- Difficulty index: `algorithm/README_DIFFICULTY.md`

## Data Sources

- Global problems: `algorithm/src/main/resources/merged_problems.json`
- LCR problems: no data source yet.

## Scripts By Phase

- JavaDoc:
  - `scripts/update_javadoc.py --class <ClassName> --scope <global|lcr>`
  - `scripts/validate_javadoc.py --class <ClassName> --scope <global|lcr>`
- Tests:
  - `scripts/generate_test.py --class <ClassName> --scope <global|lcr>`
  - `scripts/validate_test_style.py --class <ClassName> --scope <global|lcr>`
- README:
  - `scripts/update_readme.py`
  - `scripts/validate_readme_counts.py`
- Coverage:
  - `scripts/check_coverage.py --classes <ClassName> [<ClassName> ...]`

## Quick Workflow (Required)

1. `MUST` verify class naming: `LeetCodeXXXX(_N)` for global, `LCRXXXX(_N)` for LCR.
2. `MUST` update class-level JavaDoc.
3. `MUST` add or update tests for the target class.
4. `MUST` validate JavaDoc and test style.
5. `MUST` update `algorithm/README_DIFFICULTY.md` and validate counts.
6. `MUST` run `mvn test jacoco:report` and ensure tests pass.
7. `MUST` ensure `BRANCH_MISSED = 0` for new or modified classes.

## Scope Differences

- Global:
  - `MUST` pull title, slug, difficulty, and description from `merged_problems.json`.
  - `MUST` use link format `https://leetcode.com/problems/<slug>`.
  - `MUST` keep one README record per problem (`LeetCodeXXXX - Title`, no `_1/_2/_3`).
  - If JSON data is missing, `MUST` ask the user before proceeding.
- LCR:
  - `MUST` keep link/title/description blank unless user provides data.
  - `MUST` use `Difficulty: Unknown` unless user provides difficulty.
  - `MUST` keep one README record per problem (`LCRXXXX - Title`, title may be blank).

## JavaDoc Rules (Required)

Use `LeetCode0001` as the structural reference.

- `MUST` keep section order: link, description, difficulty, approach, time, space.
- `MUST` use `<p>` separators between sections.
- `MUST` keep description plain text, with `<br>` line breaks only.
- `MUST` format headers exactly:
  - `Approach: ... <br>` followed by at least one bullet line.
  - `Time Complexity: ... <br>` followed by at least one bullet line.
  - `Space Complexity: ... <br>` followed by at least one bullet line.
- `MUST` keep links free of `/description`.

## JavaDoc Stub (Reference)

```java
/**
 * <a href="https://leetcode.com/problems/<slug>">LeetCode N: Title</a>
 * <p>
 * Description line 1. <br>
 * Description line 2. <br>
 * Description line 3.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Short approach header. <br>
 * - Bullet explanation line 1. <br>
 * - Bullet explanation line 2.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: brief definition.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: brief definition.
 */
```

## Testing Gates (Required)

- `MUST` place LeetCode official examples before supplemental coverage cases.
- `MUST` use variant dispatch map; do not call solution methods directly in test methods.
- `MUST` use a single parameterized test flow where practical.
- `MUST` pass `scripts/validate_test_style.py`.
- `MUST` pass `mvn test jacoco:report`.
- `MUST` fix tests and rerun if any failures occur.
- `MUST` ensure branch coverage is complete for target classes via `jacoco.csv` (prefer `scripts/check_coverage.py`).

## Test Style Conventions (Recommended)

- `SHOULD` name solution fields with numeric suffixes (`SOLUTION_1`, `SOLUTION_2`).
- `SHOULD` use tree variant keys in form `[dfs/bfs]_[recursive/iterative]_[traverse/divide_conquer]_[with_metadata]`.
- `SHOULD` prefix metadata in keys with `with_`.
- `SHOULD` keep test file order:
  - solution fields
  - `@FunctionalInterface` (if used)
  - `ALGO_VARIANTS`
  - parameterized test (`[{index}] case={0}, algo={1}`)
  - `allCombinations`
  - `testCases`
  - `TestCase` record (if used)
- If `@FunctionalInterface` is used, `ALGO_VARIANTS` `SHOULD` use that interface type.

## Guardrails

- `MUST NOT` modify unrelated packages.
- `MUST NOT` chase branch coverage in non-target packages unless user asks.
