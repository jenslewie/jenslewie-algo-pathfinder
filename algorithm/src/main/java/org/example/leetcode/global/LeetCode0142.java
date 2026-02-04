package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle-ii">LeetCode 142: Linked List Cycle II</a>
 * <p>
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null. <br>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter. <br>
 * Do not modify the linked list. <br>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * <p>
 * Difficulty: Medium
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
