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
- Do not include `@leetcodeDifficulty`

## Global workflow

1. Add/verify solution class name: `LeetCodeXXXX` or `LeetCodeXXXX_N` as needed.
2. Use `merged_problems.json` to pull title, slug, difficulty, description.
3. Fill JavaDoc using the standard format and `leetcode.com` link.
4. Add/extend tests to achieve 100% line and branch coverage for new or modified logic.
5. Update `algorithm/README_DIFFICULTY.md`:
   - Global section only
   - One record per problem (no `_1/_2/_3` suffixes)
   - Format: `LeetCodeXXXX - Title`
   - Group by difficulty

## LCR workflow

1. Class names are `LCRXXXX` or `LCRXXXX_N`.
2. JavaDoc:
   - Keep link/title/description blank unless user provides
   - Keep difficulty `Unknown` unless user provides
   - Maintain standard section layout
3. Add tests to reach 100% line and branch coverage for new or modified logic.
4. Update `algorithm/README_DIFFICULTY.md`:
   - LCR section
   - One record per problem (no `_1/_2/_3` suffixes)
   - Format: `LCRXXXX - Title` (title blank if unknown)
   - Group by difficulty

## Testing

- Run `mvn test jacoco:report` (no confirmation) after changes to ensure `jacoco.csv` is generated.
- Check `algorithm/target/site/jacoco/jacoco.csv` and ensure new/modified classes have `BRANCH_MISSED = 0`.
- If any new/modified class has missed branches, add tests to cover them and re-run `mvn test jacoco:report`.

## Guardrails

- Keep all links free of `/description`.
- Do not modify unrelated packages.
- Do not chase branch coverage in non-target packages unless explicitly requested.
- Keep descriptions plain text (no HTML tags beyond `<br>` for line breaks).
- If JSON data is missing for a global problem, ask the user how to proceed.
