package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 1104: Path In Zigzag Labelled Binary Tree")
class LeetCode1104Test {

    private static final LeetCode1104 SOLUTION_1 = new LeetCode1104();
    private static final Map<String, PathInZigZagTreeFunction> ALGO_VARIANTS = Map.of(
            "iterative_reverse_traverse_with_level_mirror_mapping", SOLUTION_1::pathInZigZagTree
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.label, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", 14, List.of(1, 3, 4, 14)),
                new TestCase("example_2", 26, List.of(1, 2, 6, 10, 26)),

                // === Additional Coverage ===
                new TestCase("root_node", 1, List.of(1)),
                new TestCase("level_two_right_node", 2, List.of(1, 2)),
                new TestCase("power_of_two_label", 16, List.of(1, 3, 4, 15, 16))
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, label={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, int label, List<Integer> expected) {
        List<Integer> actual = ALGO_VARIANTS.get(algoName).apply(label);
        assertEquals(expected, actual,
                () -> "Case '%s' with algo='%s' failed. label=%d".formatted(caseName, algoName, label));
    }

    @FunctionalInterface
    interface PathInZigZagTreeFunction {
        List<Integer> apply(int label);
    }

    private record TestCase(String name, int label, List<Integer> expected) {
    }
}
