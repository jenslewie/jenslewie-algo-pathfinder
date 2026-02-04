package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list">LeetCode 114: Flatten Binary Tree to Linked List</a>
 * <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Reverse preorder (right-left-root). <br>
 * - Traverse in reverse preorder while linking nodes to a head pointer. <br>
 * - Reuse the right pointer to build the list.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
 */
public class LeetCode0114_3 {

    private TreeNode head;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = head;
        head = root;
    }

}
