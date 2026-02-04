package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list">LeetCode 114: Flatten Binary Tree to Linked List</a>
 * <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Preorder traversal with a queue. <br>
 * - Collect nodes in preorder. <br>
 * - Rewire pointers to form a right-skewed list.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Queue stores all nodes in preorder.
 */
public class LeetCode0114_1 {

    private final Queue<TreeNode> queue = new LinkedList<>();

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root);
        root = queue.poll();
        TreeNode p = root;
        while (!queue.isEmpty()) {
            p.right = queue.poll();
            p.left = null;
            p = p.right;
        }
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        queue.offer(root);
        traverse(root.left);
        traverse(root.right);
    }

}
