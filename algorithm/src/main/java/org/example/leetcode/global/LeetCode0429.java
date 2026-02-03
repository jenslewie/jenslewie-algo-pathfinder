package org.example.leetcode.global;

import org.example.model.tree.NaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-level-order-traversal">LeetCode 429: N-ary Tree Level Order Traversal</a>
 * <p>
 * Approach: BFS level-order traversal. <br>
 * - Use a queue to process nodes level by level. <br>
 * - Collect values for each level.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(w) <br>
 * - w: maximum width of the tree in the queue.
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
