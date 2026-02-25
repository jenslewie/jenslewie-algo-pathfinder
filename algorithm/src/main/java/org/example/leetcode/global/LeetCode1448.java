package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree">LeetCode 1448: Count Good Nodes in Binary Tree</a>
 * <p>
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X. <br>
 * Return the number of good nodes in the binary tree.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: DFS with running maximum along root-to-node path. <br>
 * - A node is good if its value is at least the maximum seen so far. <br>
 * - Recurse to children with updated path maximum.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth for tree height.
 */
public class LeetCode1448 {

    private int ans;

    public int goodNodes(TreeNode root) {
        ans = 0;
        traverse(root, root.val);
        return ans;
    }

    private void traverse(TreeNode node, int maxValue) {
        if (node == null) {
            return;
        }
        if (node.val >= maxValue) {
            ans++;
        }
        traverse(node.left, Math.max(node.val, maxValue));
        traverse(node.right, Math.max(node.val, maxValue));
    }

}
