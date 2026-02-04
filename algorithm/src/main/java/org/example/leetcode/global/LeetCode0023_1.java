package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists">LeetCode 23: Merge k Sorted Lists</a>
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order. <br>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Difficulty: Hard
 * <p>
 * Approach: Min-heap (priority queue). <br>
 * - Push the head of each list into the heap. <br>
 * - Repeatedly extract the smallest node and push its next node.
 * <p>
 * Time Complexity: O(N * * log(k)) <br>
 * - N: total number of nodes; k: number of lists.
 * <p>
 * Space Complexity: O(k) <br>
 * - Heap holds at most k nodes.
 */
public class LeetCode0023_1 {

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
