package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 234: Palindrome Linked List")
class LeetCode0234Test {

    private static final LeetCode0234 LEET_CODE = new LeetCode0234();

    @ParameterizedTest(name = "[{index}] case={0}, head={1}")
    @MethodSource("testCases")
    void testIsPalindrome(String caseName, Integer[] headArray, boolean expected) {
        ListNode head = LinkedListBuilder.build(headArray);
        boolean actual = LEET_CODE.isPalindrome(head);
        assertEquals(expected, actual, () -> "Case '%s' failed. head=%s"
                .formatted(caseName, Arrays.toString(headArray)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("palindrome_even", new Integer[]{1, 2, 2, 1}, true),
                Arguments.of("not_palindrome", new Integer[]{1, 2}, false)
        );
    }
}
