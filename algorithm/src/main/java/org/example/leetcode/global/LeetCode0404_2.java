package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/sum-of-left-leaves">LeetCode 404: Sum of Left Leaves</a>
 * <p>
 * Given the root of a binary tree, return the sum of all left leaves. <br>
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Recursive divide-and-conquer aggregation. <br>
 * - Recursively sum left subtree and right subtree contributions. <br>
 * - Add current node's left child value when that child is a leaf.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion stack depth for tree height.
 */
public class LeetCode0404_2 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        }

        return ans;
    }

}
