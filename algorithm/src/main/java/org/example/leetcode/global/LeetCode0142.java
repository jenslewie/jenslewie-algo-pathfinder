package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii">LeetCode 142: Linked List Cycle II</a>
 * <p>
 * Approach: Floyd's cycle detection with entry finding. <br>
 * - Detect cycle using slow/fast pointers. <br>
 * - Reset one pointer to head; move both to find the entry node.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; pointers traverse at most linear steps.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
