package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
public class LeetCode0023_2 {

    /**
     * Time Complexity: O(N * log(k))
     * - N: total number of nodes across all lists
     * - k: number of linked lists
     * - We divide the lists into halves log(k) times, and each level processes all N nodes
     * <p>
     * Space Complexity: O(log(k))
     * - Recursion depth is O(log(k))
     * - Each recursion level uses constant extra space
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}