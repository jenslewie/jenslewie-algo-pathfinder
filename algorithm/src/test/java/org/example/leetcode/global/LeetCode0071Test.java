package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 71: Simplify Path - Algorithm Variants")
class LeetCode0071Test {

    private static final LeetCode0071_1 LEET_CODE_1 = new LeetCode0071_1();
    private static final LeetCode0071_2 LEET_CODE_2 = new LeetCode0071_2();

    @FunctionalInterface
    interface SimplifyPathFunction {
        String apply(String path);
    }

    private static final Map<String, SimplifyPathFunction> ALGO_VARIANTS = Map.of(
            "deque_based", LEET_CODE_1::simplifyPath,
            "stack_based", LEET_CODE_2::simplifyPath
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, path={2}")
    @MethodSource("allCombinations")
    void testSimplifyPath(String caseName, String algoName, String path, String expected) {
        String actual = ALGO_VARIANTS.get(algoName).apply(path);

        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. path=%s".formatted(caseName, algoName, path));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.path, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1", "/home/", "/home"),

                // Example 2 from LeetCode
                new TestCase("example_2", "/../", "/"),

                // Example 3 from LeetCode
                new TestCase("example_3", "/home//foo/", "/home/foo"),

                // Deep nesting with ..
                new TestCase("deep_parent", "/a/./b/../../c/", "/c"),

                // Multiple .. at root
                new TestCase("multiple_parent_at_root", "/../../", "/"),

                // Single slash
                new TestCase("single_slash", "/", "/"),

                // Only dots
                new TestCase("only_dots", "/./././", "/"),

                // Empty string (though LeetCode guarantees non-empty)
                new TestCase("empty_path", "", "/"),

                // Complex real-world path
                new TestCase("complex_path", "/a/b/c/../d/./e/../../f", "/a/b/f"),

                // Trailing ..
                new TestCase("trailing_parent", "/a/b/..", "/a"),

                // Leading and trailing slashes with empties
                new TestCase("slashes_and_empties", "///a////b//../c/././.", "/a/c")
        );
    }

    private record TestCase(String name, String path, String expected) {
    }

}