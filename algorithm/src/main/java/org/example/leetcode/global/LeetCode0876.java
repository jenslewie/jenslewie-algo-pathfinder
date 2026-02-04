package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/middle-of-the-linked-list">LeetCode 876: Middle of the Linked List</a>
 * <p>
 * Approach: Slow/fast pointers. <br>
 - Move fast by two steps and slow by one. <br>
 - Slow ends at the middle.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; single traversal.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
 */
public class LeetCode0876 {

    public ListNode middleNode(ListNode head) {
        ListNode p1 = head, p2 = head;

        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }

        return p2;
    }

}
