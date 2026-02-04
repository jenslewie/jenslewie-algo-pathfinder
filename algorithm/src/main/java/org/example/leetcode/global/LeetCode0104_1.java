package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree">LeetCode 104: Maximum Depth of Binary Tree</a>
 * <p>
 * Given the root of a binary tree, return its maximum depth. <br>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: DFS recursion. <br>
 * - Compute the depth of left and right subtrees. <br>
 * - Return max(left, right) + 1.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
 */
public class LeetCode0104_1 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
