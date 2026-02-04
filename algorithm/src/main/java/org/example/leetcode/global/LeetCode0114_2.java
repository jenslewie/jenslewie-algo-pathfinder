package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list">LeetCode 114: Flatten Binary Tree to Linked List</a>
 * <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Postorder flatten with tail scan. <br>
 * - Flatten left and right subtrees. <br>
 * - Move the left subtree to the right and append the original right subtree.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - In the worst case, each node scans to the rightmost tail.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
 */
public class LeetCode0114_2 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
