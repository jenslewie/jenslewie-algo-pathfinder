package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 */
public class LeetCode0111_2 {

    private int minDepth = Integer.MAX_VALUE;
    private int currentDepth = 0;

    /**
     * DFS (Depth-First Search) approach with traversal
     * Time Complexity: O(n)
     * - n: number of nodes in the tree
     * - We visit each node at most once
     * <p>
     * Space Complexity: O(h)
     * - h: height of the tree
     * - Due to recursion stack in the worst case (skewed tree)
     */
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