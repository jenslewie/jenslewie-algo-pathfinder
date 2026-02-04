package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node">LeetCode 116: Populating Next Right Pointers in Each Node</a>
 * <p>
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition: <br>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. <br>
 * Initially, all next pointers are set to NULL. <br>
 * Follow-up:
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: BFS level-order traversal. <br>
 * - Traverse each level and connect nodes using the queue order. <br>
 * - The next pointer points to the next node in the same level.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Queue holds up to a full level of nodes.
 */
public class LeetCode0116_1 {

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }

        var queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i != size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }

}
