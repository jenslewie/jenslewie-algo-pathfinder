package org.example.leetcode.lcr;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof">LCR 141: 训练计划 III</a>
 * <p>
 * 给定一个头节点为 head 的单链表用于记录一系列核心肌群训练编号，请将该系列训练编号 倒序 记录于链表并返回。
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Iterative linked-list reversal. <br>
 * - Traverse nodes while rewiring each `next` pointer to the previous node. <br>
 * - Move forward with saved next pointer and return the new head at the end.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Uses constant pointer variables.
 */
public class LCR0141 {

    public ListNode trainningPlan(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

}
