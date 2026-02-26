package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 0386: Lexicographical Numbers")
class LeetCode0386Test {

    private static final LeetCode0386_1 SOLUTION_1 = new LeetCode0386_1();
    private static final LeetCode0386_2 SOLUTION_2 = new LeetCode0386_2();
    private static final Map<String, LexicalOrderFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_preorder_with_implicit_prefix_tree", SOLUTION_1::lexicalOrder,
            "iterative_simulation_with_lexical_successor_rules", SOLUTION_2::lexicalOrder
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.n, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", 13, List.of(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9)),
                new TestCase("example_2", 2, List.of(1, 2)),

                // === Additional Coverage ===
                new TestCase("n_is_one", 1, List.of(1)),
                new TestCase("crosses_teens_and_twenties", 20, List.of(1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 3, 4, 5, 6, 7, 8, 9)),
                new TestCase("n_is_nine", 9, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9))
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, n={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, int n, List<Integer> expected) {
        List<Integer> actual = ALGO_VARIANTS.get(algoName).apply(n);
        assertEquals(expected, actual,
                () -> "Case '%s' with algo='%s' failed. n=%d".formatted(caseName, algoName, n));
    }

    @FunctionalInterface
    interface LexicalOrderFunction {
        List<Integer> apply(int n);
    }

    private record TestCase(String name, int n, List<Integer> expected) {
    }
}
