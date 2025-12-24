package org.example.leetcode.utility;

import org.example.model.linkedlist.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LinkedListUtility {

    public static void verify(int[] expectedValues, ListNode head) {
        for (int expectedValue : expectedValues) {
            assertEquals(expectedValue, head.val);
            head = head.next;
        }
        assertNull(head);
    }

    public static void verifyCycle(int[] expectedValues, ListNode head) {
        for (int expectedValue : expectedValues) {
            assertEquals(expectedValue, head.val);
            head = head.next;
        }
    }

}
