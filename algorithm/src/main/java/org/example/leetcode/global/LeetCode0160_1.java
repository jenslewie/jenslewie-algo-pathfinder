package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists">LeetCode 160: Intersection of Two Linked Lists</a>
 * <p>
 * Approach: Length difference alignment. <br>
 * - Compute lengths of both lists and advance the longer one. <br>
 * - Move both pointers together until they meet.
 * <p>
 * Time Complexity: O(m + n) <br>
 * - m, n: lengths of the two lists; each node is visited at most twice.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0160_1 {

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
