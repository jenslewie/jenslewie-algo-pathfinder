package org.example.leetcode.global;

import org.example.model.tree.NaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
 */
public class LeetCode0429 {

    public List<List<Integer>> levelOrder(NaryTreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> tree = new ArrayList<>();
        Queue<NaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> children = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                NaryTreeNode node = queue.poll();
                children.add(node.value);
                queue.addAll(node.children);
            }
            tree.add(children);
        }

        return tree;
    }

}
