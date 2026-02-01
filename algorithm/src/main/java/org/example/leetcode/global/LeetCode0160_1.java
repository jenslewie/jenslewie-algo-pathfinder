package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 */
public class LeetCode0160_1 {

    /**
     * Length difference approach
     * Time Complexity: O(m + n)
     * - m: length of list A
     * - n: length of list B
     * - We iterate through both lists twice (once to measure lengths, once to find intersection)
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode p1 = headA, p2 = headB;

        while (p1 != null) {
            lenA++;
            p1 = p1.next;
        }
        while (p2 != null) {
            lenB++;
            p2 = p2.next;
        }

        p1 = headA;
        p2 = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                p2 = p2.next;
            }
        }

        while (p2 != null) {
            if (p1 == p2) {
                return p2;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }
}