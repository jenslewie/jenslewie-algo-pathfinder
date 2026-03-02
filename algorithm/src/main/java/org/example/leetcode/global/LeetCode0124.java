package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum">LeetCode 124: Binary Tree Maximum Path Sum</a>
 * <p>
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root. <br>
 * The path sum of a path is the sum of the node's values in the path. <br>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * <p>
 * Difficulty: Hard
 * <p>
 * Approach: Post-order DFS with downward gain propagation. <br>
 * - For each node, keep the best downward gain from left/right as non-negative contributions. <br>
 * - Treat current node as turning point to update global best with left + node + right.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes in the tree.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth bounded by tree height.
 */
public class LeetCode0124 {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(0, maxGain(root.left));
        int rightGain = Math.max(0, maxGain(root.right));
        int priceNewPath = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewPath);
        return root.val + Math.max(leftGain, rightGain);
    }
}
