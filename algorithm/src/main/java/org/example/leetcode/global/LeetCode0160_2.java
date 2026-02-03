package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists">LeetCode 160: Intersection of Two Linked Lists</a>
 * <p>
 * Approach: Two-pointer switch. <br>
 * - Traverse list A then list B with one pointer, and vice versa. <br>
 * - They meet at the intersection or at null.
 * <p>
 * Time Complexity: O(m + n) <br>
 * - m, n: lengths of the two lists; each pointer traverses both lists once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0160_2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;

        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }
}
