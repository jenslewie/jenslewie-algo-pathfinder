package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list">LeetCode 114: Flatten Binary Tree to Linked List</a>
 * <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Postorder recursion returning tail. <br>
 * - Flatten left and right subtrees and return the tail node. <br>
 * - Stitch left subtree between root and right subtree.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is processed once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
 */
public class LeetCode0114_4 {

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);

        if (left != null) {
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return right != null ? right : left != null ? left : root;
    }

}
