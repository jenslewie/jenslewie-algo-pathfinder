package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeetCode0234Test {

    private LeetCode0234 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0234();
    }

    @Test
    void test1() {
        ListNode head = LinkedListBuilder.build(new Integer[]{1, 2, 2, 1});
        assertTrue(leetCode.isPalindrome(head));
    }

    @Test
    void test2() {
        ListNode head = LinkedListBuilder.build(new Integer[]{1, 2});
        assertFalse(leetCode.isPalindrome(head));
    }
}
