package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.com/problems/partition-list">LeetCode 86: Partition List</a>
 * <p>
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x. <br>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Two lists for < x and >= x, then concatenate. <br>
 * - Walk the list and append nodes to the appropriate list. <br>
 * - Connect the two lists at the end.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space for pointers.
 */
public class LeetCode0086 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode p1 = dummy1, p2 = dummy2;

        while (head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = null;

            if (cur.val < x) {
                p1.next = cur;
                p1 = p1.next;
            } else {
                p2.next = cur;
                p2 = p2.next;
            }
        }

        p1.next = dummy2.next;

        return dummy1.next;
    }

}
