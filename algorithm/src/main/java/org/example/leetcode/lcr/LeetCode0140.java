package org.example.leetcode.lcr;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/description/">LeetCode LCR 140: Kth Node From End of List</a>
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Two pointers with a gap. <br>
 - Advance first pointer cnt steps. <br>
 - Move both until first reaches end.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; single pass.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
 */
public class LeetCode0140 {

    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode p1 = head, p2 = head;

        for (int i = 0; i < cnt; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

}
