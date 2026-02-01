package org.example.leetcode.lcr;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.utility.LinkedListUtility;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@DisplayName("LCR 140: Training Plan (Kth from End)")
class LeetCode0140Test {

    private static final LeetCode0140 LEET_CODE = new LeetCode0140();

    @ParameterizedTest(name = "[{index}] case={0}, head={1}, cnt={2}")
    @MethodSource("testCases")
    void testTrainingPlan(String caseName, Integer[] headArray, int cnt, int[] expected) {
        ListNode head = LinkedListBuilder.build(headArray);
        ListNode result = LEET_CODE.trainingPlan(head, cnt);
        LinkedListUtility.verify(expected, result, () -> "Case '%s' failed. head=%s, cnt=%d"
                .formatted(caseName, Arrays.toString(headArray), cnt));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("kth_1", new Integer[]{2, 4, 7, 8}, 1, new int[]{8})
        );
    }
}
