package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class LeetCode0206 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        while (head.next != null) {
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }

        return dummy.next;
    }

}
