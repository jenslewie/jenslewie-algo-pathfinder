package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle">LeetCode 141: Linked List Cycle</a>
 * <p>
 * Approach: Floyd's cycle detection. <br>
 * - Use slow and fast pointers moving at different speeds. <br>
 * - If they meet, a cycle exists.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each pointer advances linearly.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0141 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

}
