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

import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("LeetCode 21: Merge Two Sorted Lists")
class LeetCode0021Test {

    private static final LeetCode0021 SOLUTION = new LeetCode0021();

    @ParameterizedTest(name = "[{index}] case={0}, list1={1}, list2={2}")
    @MethodSource("testCases")
    void testMergeTwoLists(String caseName, Integer[] list1Array, Integer[] list2Array, int[] expected) {
        ListNode list1 = LinkedListBuilder.build(list1Array);
        ListNode list2 = LinkedListBuilder.build(list2Array);

        ListNode result = SOLUTION.mergeTwoLists(list1, list2);

        if (expected == null) {
            assertNull(result, () -> "Case '%s' failed. list1=%s, list2=%s"
                    .formatted(caseName, Arrays.toString(list1Array), Arrays.toString(list2Array)));
        } else {
            LinkedListUtility.verify(expected, result, () -> "Case '%s' failed. list1=%s, list2=%s"
                    .formatted(caseName, Arrays.toString(list1Array), Arrays.toString(list2Array)));
        }
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        new Integer[]{1, 3, 4, 5},
                        new Integer[]{2, 5, 6},
                        new int[]{1, 2, 3, 4, 5, 5, 6}),

                // Example 2 from LeetCode: first list empty
                Arguments.of("example_2",
                        new Integer[]{},
                        new Integer[]{2, 5, 6},
                        new int[]{2, 5, 6}),

                // Example 3 from LeetCode: both empty
                Arguments.of("example_3",
                        new Integer[]{},
                        new Integer[]{},
                        null),

                // Second list empty
                Arguments.of("second_empty",
                        new Integer[]{1, 2, 3},
                        new Integer[]{},
                        new int[]{1, 2, 3})
        );
    }
}
