package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree">LeetCode 111: Minimum Depth of Binary Tree</a>
 * <p>
 * Given a binary tree, find its minimum depth. <br>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node. <br>
 * Note: A leaf is a node with no children.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: DFS traversal with depth tracking. <br>
 * - Traverse all root-to-leaf paths. <br>
 * - Track the minimum depth across leaf nodes.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
 */
public class LeetCode0111_2 {

    private int minDepth = Integer.MAX_VALUE;
    private int currentDepth = 0;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.minDepth = Integer.MAX_VALUE;
        this.currentDepth = 0;
        traverse(root);
        return this.minDepth;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        currentDepth++;
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, currentDepth);
        }
        traverse(root.left);
        traverse(root.right);
        currentDepth--;
    }
}
