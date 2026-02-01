package org.example.leetcode.utility;

import org.example.model.linkedlist.ListNode;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LinkedListUtility {

    public static void verify(int[] expectedValues, ListNode head) {
        verify(expectedValues, head, () -> "LinkedList verification failed");
    }

    public static void verify(int[] expectedValues, ListNode head, Supplier<String> messageSupplier) {
        ListNode current = head;
        for (int i = 0; i < expectedValues.length; i++) {
            int expectedValue = expectedValues[i];
            final ListNode finalCurrent = current;
            final int index = i;
            assertEquals(expectedValue, current.val, () -> messageSupplier.get() + ". At index " + index + ": expected=" + expectedValue + ", but node was " + (finalCurrent == null ? "null" : finalCurrent.val));
            current = current.next;
        }
        final ListNode finalCurrent = current;
        assertNull(current, () -> messageSupplier.get() + ". Expected list to end, but found more nodes starting with " + (finalCurrent == null ? "null" : finalCurrent.val));
    }

    public static void verifyCycle(int[] expectedValues, ListNode head) {
        verifyCycle(expectedValues, head, () -> "LinkedList cycle verification failed");
    }

    public static void verifyCycle(int[] expectedValues, ListNode head, Supplier<String> messageSupplier) {
        ListNode current = head;
        for (int i = 0; i < expectedValues.length; i++) {
            int expectedValue = expectedValues[i];
            final ListNode finalCurrent = current;
            final int index = i;
            assertEquals(expectedValue, current.val, () -> messageSupplier.get() + ". At index " + index + ": expected=" + expectedValue + ", but was " + (finalCurrent == null ? "null" : finalCurrent.val));
            current = current.next;
        }
    }

}
