package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeetCode0141Test {

    private LeetCode0141 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0141();
    }

    @Test
    void test1() {
        ListNode head = LinkedListBuilder.buildCycle(new Integer[] {3, 2, 0, -4}, 1);

        assertTrue(leetCode.hasCycle(head));
    }

    @Test
    void test2() {
        ListNode head = LinkedListBuilder.buildCycle(new Integer[] {1, 2}, 0);

        assertTrue(leetCode.hasCycle(head));
    }

    @Test
    void test3() {
        ListNode head = LinkedListBuilder.build(new Integer[] {1});

        assertFalse(leetCode.hasCycle(head));
    }

}
