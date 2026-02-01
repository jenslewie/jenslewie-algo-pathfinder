package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.utility.LinkedListUtility;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

@DisplayName("LeetCode 83: Remove Duplicates from Sorted List - Algorithm Variants")
class LeetCode0083Test {

    private static final LeetCode0083_1 LEET_CODE_1 = new LeetCode0083_1();
    private static final LeetCode0083_2 LEET_CODE_2 = new LeetCode0083_2();

    private static final Map<String, Function<ListNode, ListNode>> ALGO_VARIANTS = Map.of(
            "single_pass_sentinel", LEET_CODE_1::deleteDuplicates,
            "two_pointer_sentinel", LEET_CODE_2::deleteDuplicates
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, head={2}")
    @MethodSource("allCombinations")
    void testDeleteDuplicates(String caseName, String algoName, Integer[] headArray, int[] expected) {
        ListNode head = LinkedListBuilder.build(headArray);
        ListNode result = ALGO_VARIANTS.get(algoName).apply(head);
        LinkedListUtility.verify(expected, result, () -> "Case '%s' with algo='%s' failed. head=%s"
                .formatted(caseName, algoName, Arrays.toString(headArray)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.headArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1",
                        new Integer[]{1, 1, 2},
                        new int[]{1, 2}),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new Integer[]{1, 1, 2, 3, 3},
                        new int[]{1, 2, 3}),

                // Example 3: All duplicates
                new TestCase("example_3",
                        new Integer[]{1, 1, 1},
                        new int[]{1})
        );
    }

    private record TestCase(String name, Integer[] headArray, int[] expected) {
    }
}
