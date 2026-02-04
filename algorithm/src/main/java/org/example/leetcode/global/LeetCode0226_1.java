package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree">LeetCode 226: Invert Binary Tree</a>
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Recursive swap. <br>
 * - Recursively invert left and right subtrees. <br>
 * - Swap the children.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
 */
public class LeetCode0226_1 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;

        return root;
    }

}
