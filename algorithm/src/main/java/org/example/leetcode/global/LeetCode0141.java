package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle">LeetCode 141: Linked List Cycle</a>
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it. <br>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter. <br>
 * Return true if there is a cycle in the linked list. Otherwise, return false. <br>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * <p>
 * Difficulty: Easy
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
