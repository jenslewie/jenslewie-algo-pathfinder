package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 0331: Verify Preorder Serialization of a Binary Tree")
class LeetCode0331Test {

    private static final LeetCode0331 SOLUTION_1 = new LeetCode0331();
    private static final Map<String, IsValidSerializationFunction> ALGO_VARIANTS = Map.of(
            "greedy_iterative_traverse_with_in_out_degree_slots", SOLUTION_1::isValidSerialization
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.preorder, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", "9,3,4,#,#,1,#,#,2,#,6,#,#", true),
                new TestCase("example_2", "1,#", false),
                new TestCase("example_3", "9,#,#,1", false),

                // === Additional Coverage ===
                new TestCase("single_null_tree", "#", true),
                new TestCase("single_node_tree", "1,#,#", true),
                new TestCase("missing_null_children", "1", false),
                new TestCase("too_many_nulls", "#,#", false),
                new TestCase("extra_tail_token", "1,#,#,#", false)
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, preorder={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, String preorder, boolean expected) {
        boolean actual = ALGO_VARIANTS.get(algoName).apply(preorder);
        assertEquals(expected, actual,
                () -> "Case '%s' with algo='%s' failed. preorder=%s".formatted(caseName, algoName, preorder));
    }

    @FunctionalInterface
    interface IsValidSerializationFunction {
        boolean apply(String preorder);
    }

    private record TestCase(String name, String preorder, boolean expected) {
    }
}
