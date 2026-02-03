package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.utility.LinkedListUtility;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@DisplayName("LeetCode 445: Add Two Numbers II")
class LeetCode0445Test {

    private static final LeetCode0445 SOLUTION = new LeetCode0445();

    @ParameterizedTest(name = "[{index}] case={0}, l1={1}, l2={2}")
    @MethodSource("testCases")
    void testAddTwoNumbers(String caseName, Integer[] l1Array, Integer[] l2Array, int[] expected) {
        ListNode l1 = LinkedListBuilder.build(l1Array);
        ListNode l2 = LinkedListBuilder.build(l2Array);

        ListNode result = SOLUTION.addTwoNumbers(l1, l2);

        String l1Str = l1Array == null ? "null" : Arrays.toString(l1Array);
        String l2Str = l2Array == null ? "null" : Arrays.toString(l2Array);
        LinkedListUtility.verify(expected, result, () -> "Case '%s' failed. l1=%s, l2=%s"
                .formatted(caseName, l1Str, l2Str));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        new Integer[]{2, 4, 3},
                        new Integer[]{5, 6, 4},
                        new int[]{8, 0, 7}),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        new Integer[]{0},
                        new Integer[]{0},
                        new int[]{0}),

                // Example 3: different lengths
                Arguments.of("example_3",
                        new Integer[]{7, 2, 4, 3},
                        new Integer[]{5, 6, 4},
                        new int[]{7, 8, 0, 7}),

                // One list is null
                Arguments.of("l1_null",
                        null,
                        new Integer[]{1, 2, 3},
                        new int[]{1, 2, 3}),

                Arguments.of("l2_null",
                        new Integer[]{9, 9},
                        null,
                        new int[]{9, 9}),

                // Carry over after both stacks empty
                Arguments.of("carry_over",
                        new Integer[]{9, 9},
                        new Integer[]{1},
                        new int[]{1, 0, 0})
        );
    }
}
