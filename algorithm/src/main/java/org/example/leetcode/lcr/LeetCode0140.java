package org.example.leetcode.lcr;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/description/
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
