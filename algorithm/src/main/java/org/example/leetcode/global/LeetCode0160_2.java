package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 */
public class LeetCode0160_2 {

    /**
     * Two pointers approach
     * Time Complexity: O(m + n)
     * - m: length of list A
     * - n: length of list B
     * - Both pointers will traverse both lists once
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;

        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }
}