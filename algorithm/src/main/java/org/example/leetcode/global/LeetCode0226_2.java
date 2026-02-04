package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree">LeetCode 226: Invert Binary Tree</a>
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: DFS traversal with swap. <br>
 * - Swap children at each node during traversal. <br>
 * - Continue recursively to both subtrees.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
 */
public class LeetCode0226_2 {

    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;

        traverse(node.left);
        traverse(node.right);
    }

}
