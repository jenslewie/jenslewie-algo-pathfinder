---
name: leet-flow
description: Standardize LeetCode solution additions with JavaDoc, tests, and README index updates for global and LCR packages.
---

# leet-flow

Use this skill when adding a new LeetCode solution in this repo. It standardizes class-level JavaDoc, test coverage, and the difficulty index.

## Scope

- Global: `algorithm/src/main/java/org/example/leetcode/global`
- LCR: `algorithm/src/main/java/org/example/leetcode/lcr`
- Tests: `algorithm/src/test/java/org/example/leetcode/global` and `algorithm/src/test/java/org/example/leetcode/lcr`
- Index: `algorithm/README_DIFFICULTY.md`

## Data sources

- Global problems: `algorithm/src/main/resources/merged_problems.json`
- LCR problems: no data source yet; leave hyperlink/title/description blank unless user provides.

## Scripts (recommended)

Use the bundled scripts for consistent results:

- `scripts/update_javadoc.py --class <ClassName> --scope <global|lcr>`
- `scripts/validate_javadoc.py --class <ClassName> --scope <global|lcr>`
- `scripts/validate_test_style.py --class <ClassName> --scope <global|lcr>`
- `scripts/validate_readme_counts.py`
- `scripts/update_readme.py`
- `scripts/check_coverage.py --classes <ClassName> [<ClassName> ...]`
- `scripts/generate_test.py --class <ClassName> --scope <global|lcr>`

## JavaDoc format (class-level)

Match the style of `LeetCode0001` in global:

- First line: problem link
  - Global: `https://leetcode.com/problems/<slug>`
  - LCR: leave href/title/description blank unless user supplies data
- Description block immediately after link
- Difficulty line: `Difficulty: Easy|Medium|Hard` (Global from JSON; LCR use `Unknown` unless user provides)
- Sections in order: `Approach`, `Time Complexity`, `Space Complexity`
- Use `<p>` separators between sections
- Keep `<br>` inside section lines, but do not end the final line of Time/Space with `<br>`

## Global workflow

- Order test data with LeetCode official examples first, then add supplemental cases for coverage.
1. Add/verify solution class name: `LeetCodeXXXX` or `LeetCodeXXXX_N` as needed.
2. Use `merged_problems.json` to pull title, slug, difficulty, description.
3. Prefer `scripts/update_javadoc.py` to update the JavaDoc.
4. Add/extend tests to achieve 100% line and branch coverage for new or modified logic (prefer `scripts/generate_test.py`).
5. Validate JavaDoc formatting (prefer `scripts/validate_javadoc.py`).
6. Validate test style (prefer `scripts/validate_test_style.py`).
7. Update `algorithm/README_DIFFICULTY.md` (prefer `scripts/update_readme.py`), then validate counts (prefer
   `scripts/validate_readme_counts.py`):
   - Global section only
   - One record per problem (no `_1/_2/_3` suffixes)
   - Format: `LeetCodeXXXX - Title`
   - Group by difficulty

## LCR workflow

1. Class names are `LCRXXXX` or `LCRXXXX_N`.
2. JavaDoc (prefer `scripts/update_javadoc.py`):
   - Keep link/title/description blank unless user provides
   - Keep difficulty `Unknown` unless user provides
   - Maintain standard section layout
3. Add tests to reach 100% line and branch coverage for new or modified logic (prefer `scripts/generate_test.py`).
4. Validate JavaDoc formatting (prefer `scripts/validate_javadoc.py`).
5. Validate test style (prefer `scripts/validate_test_style.py`).
6. Update `algorithm/README_DIFFICULTY.md` (prefer `scripts/update_readme.py`), then validate counts (prefer
   `scripts/validate_readme_counts.py`):
   - LCR section
   - One record per problem (no `_1/_2/_3` suffixes)
   - Format: `LCRXXXX - Title` (title blank if unknown)
   - Group by difficulty

## Testing

- For tree algorithms, if metadata is included in the key name, prefix it with `with_` (e.g., `dfs_recursive_divide_conquer_with_height`).
- For tree algorithms, use ALGO_VARIANTS keys like `dfs_recursive_traverse_with_stack` or `bfs_iterative_traverse_with_queue` following `[dfs/bfs]_[recursive/iterative]_[traverse/divide_conquer]_[with_metadata]`.
- When multiple solutions exist, name solution variables with numeric suffixes (e.g., `SOLUTION_1`).
- Use a Map-based variant dispatch like `LeetCode0003Test` to run the same cases across all solutions; do not create one
  test method per solution.
- Do not call solution methods directly in the test method; always call `ALGO_VARIANTS.get(algoName).apply(...)`.
- Ensure test data sections are labeled: "LeetCode Official Examples" first, then "Additional Coverage".
- Prefer @ParameterizedTest and consolidate cases in a single test where possible (one test method for all variants).
- Enforce test file order:
    - SOLUTION fields
    - @FunctionalInterface (if needed)
    - ALGO_VARIANTS
    - @ParameterizedTest (name must include `[{index}] case={0}, algo={1}`; extra placeholders allowed)
    - allCombinations method
    - testCases method
    - TestCase record (if needed)
- If an @FunctionalInterface is declared, ALGO_VARIANTS must be typed to that interface (not a generic Function).
- Run `mvn test jacoco:report` (no confirmation) after changes to ensure `jacoco.csv` is generated.
- Ensure all tests pass after running `mvn test jacoco:report` (fix failing cases before proceeding).
- Check `algorithm/target/site/jacoco/jacoco.csv` and ensure new/modified classes have `BRANCH_MISSED = 0`
  (prefer `scripts/check_coverage.py --classes <ClassName>`).
- If any new/modified class has missed branches, add tests to cover them and re-run `mvn test jacoco:report`.

## Guardrails

- Keep all links free of `/description`.
- Do not modify unrelated packages.
- Do not chase branch coverage in non-target packages unless explicitly requested.
- Keep descriptions plain text (no HTML tags beyond `<br>` for line breaks).
- If JSON data is missing for a global problem, ask the user how to proceed.
