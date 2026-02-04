package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists">LeetCode 21: Merge Two Sorted Lists</a>
 * <p>
 * You are given the heads of two sorted linked lists list1 and list2. <br>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists. <br>
 * Return the head of the merged linked list.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Iterative merge with a dummy head. <br>
 * - Compare list heads and append the smaller node. <br>
 * - Attach the remaining list when one is exhausted.
 * <p>
 * Time Complexity: O(n + m) <br>
 * - n, m: lengths of the two lists; each node is visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Uses constant extra space (reuses existing nodes).
 */
public class LeetCode0021 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1000);
        ListNode p = dummy, p1 = list1, p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }

}
