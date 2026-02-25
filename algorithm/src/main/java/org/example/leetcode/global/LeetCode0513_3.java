package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/find-bottom-left-tree-value">LeetCode 513: Find Bottom Left Tree Value</a>
 * <p>
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: DFS with depth tracking and first-hit update. <br>
 * - Traverse left before right. <br>
 * - When entering a deeper level for the first time, record current node as current bottom-left value.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: every node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion stack bounded by tree height.
 */
public class LeetCode0513_3 {

    private int ans;
    private int maxDepth;

    public int findBottomLeftValue(TreeNode root) {
        ans = root.val;
        maxDepth = 0;
        traverse(root, 1);
        return ans;
    }

    private void traverse(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            ans = node.val;
        }
        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
    }

}
