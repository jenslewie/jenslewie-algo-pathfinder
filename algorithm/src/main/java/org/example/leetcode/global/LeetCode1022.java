package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers">LeetCode 1022: Sum of Root To Leaf Binary Numbers</a>
 * <p>
 * You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit. <br>
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers. <br>
 * The test cases are generated so that the answer fits in a 32-bits integer.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: DFS accumulation. <br>
 * - Carry the path value by left-shifting and adding the current bit. <br>
 * - Add the path value when reaching a leaf.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth for the tree height.
 */
public class LeetCode1022 {

    private int ans;

    public int sumRootToLeaf(TreeNode root) {
        ans = 0;
        traverse(root, 0);
        return ans;
    }

    private void traverse(TreeNode root, int path) {
        if (root == null) {
            return;
        }
        path = (path << 1) + root.val;
        if (root.left == null && root.right == null) {
            ans += path;
            return;
        }
        traverse(root.left, path);
        traverse(root.right, path);
    }
}
