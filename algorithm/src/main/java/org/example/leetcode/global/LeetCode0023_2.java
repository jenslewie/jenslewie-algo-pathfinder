package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists">LeetCode 23: Merge k Sorted Lists</a>
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order. <br>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Difficulty: Hard
 * <p>
 * Approach: Divide and conquer merge. <br>
 * - Recursively split the list array in half. <br>
 * - Merge pairs of lists until one remains.
 * <p>
 * Time Complexity: O(N * * log(k)) <br>
 * - N: total number of nodes; k: number of lists.
 * <p>
 * Space Complexity: O(log(k)) <br>
 * - Recursion depth from splitting the lists.
 */
public class LeetCode0023_2 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
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
