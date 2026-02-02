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

@DisplayName("LeetCode 86: Partition List")
class LeetCode0086Test {

    private static final LeetCode0086 SOLUTION = new LeetCode0086();

    @ParameterizedTest(name = "[{index}] case={0}, list={1}, x={2}")
    @MethodSource("testCases")
    void testPartition(String caseName, Integer[] listArray, int x, int[] expected) {
        ListNode list = LinkedListBuilder.build(listArray);
        ListNode result = SOLUTION.partition(list, x);
        LinkedListUtility.verify(expected, result, () -> "Case '%s' failed. list=%s, x=%d"
                .formatted(caseName, Arrays.toString(listArray), x));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        new Integer[]{1, 4, 3, 2, 5, 2},
                        3,
                        new int[]{1, 2, 2, 4, 3, 5}),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        new Integer[]{2, 1},
                        2,
                        new int[]{1, 2})
        );
    }
}
