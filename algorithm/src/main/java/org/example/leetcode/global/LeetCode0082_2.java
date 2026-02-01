package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 */
public class LeetCode0082_2 {

    /**
     * Single pass with sentinel approach
     * Time Complexity: O(n)
     * - n: number of nodes in the linked list
     * - We iterate through the list once
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyUniq = new ListNode(-101);
        ListNode p = head, pUniq = dummyUniq, pDup = new ListNode(-101);

        while (p != null) {
            if (p.next != null && p.val == p.next.val || p.val == pDup.val) {
                pDup.next = p;
                pDup = pDup.next;
            } else {
                pUniq.next = p;
                pUniq = pUniq.next;
            }

            p = p.next;
            pDup.next = null;
            pUniq.next = null;
        }

        return dummyUniq.next;
    }
}