package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-linked-lists">LeetCode 160: Intersection of Two Linked Lists</a>
 * <p>
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null. <br>
 * For example, the following two linked lists begin to intersect at node c1: <br>
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure. <br>
 * Note that the linked lists must retain their original structure after the function returns. <br>
 * Custom Judge: <br>
 * The inputs to the judge are given as follows (your program is not given these inputs): <br>
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
 * <p>
 * Difficulty: Easy
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
