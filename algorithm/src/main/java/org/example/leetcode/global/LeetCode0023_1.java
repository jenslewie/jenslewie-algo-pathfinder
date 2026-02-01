package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
public class LeetCode0023_1 {

    /**
     * Time Complexity: O(N * log(k))
     * - N: total number of nodes across all lists
     * - k: number of linked lists
     * - Each node is added and removed from the priority queue once, which takes O(log(k)) time
     * <p>
     * Space Complexity: O(k)
     * - Priority queue stores at most k nodes (one from each list)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }

        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            p.next = temp;
            p = p.next;

            if (temp.next != null) {
                queue.offer(temp.next);
            }
        }

        return dummy.next;
    }
}