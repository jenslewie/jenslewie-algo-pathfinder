package org.example.builder;

import org.example.model.Pair;
import org.example.model.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListBuilder {

    public static ListNode build(Integer[] arr) {
        return buildPair(arr).first();
    }

    public static ListNode fromArray(int[] arr) {
        return buildPair(Arrays.stream(arr).boxed().toArray(Integer[]::new)).first();
    }

    public static Pair<ListNode, ListNode> buildPair(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return new Pair<>(null, null);
        }

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return new Pair<>(head, cur);
    }

    public static ListNode buildCycle(Integer[] arr, int pos) {
        ListNode head = build(arr);

        ListNode cur = head, tail = head;
        int i = 0;
        while (tail.next != null) {
            if (i != pos) {
                i++;
                cur = cur.next;
            }
            tail = tail.next;
        }
        tail.next = cur;

        return head;
    }

    public static Pair<ListNode, ListNode> buildIntersectionNode(Integer[] arr1, Integer[] arr2, Integer[] arr3) {
        Pair<ListNode, ListNode> pair1 = buildPair(arr1);
        Pair<ListNode, ListNode> pair2 = buildPair(arr2);
        ListNode head3 = build(arr3);
        pair1.second().next = head3;
        pair2.second().next = head3;
        return new Pair<>(pair1.first(), pair2.first());
    }

    public static int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
