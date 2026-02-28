package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/symmetric-tree">LeetCode 101: Symmetric Tree</a>
 * <p>
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Recursive mirror comparison on paired nodes. <br>
 * - Compare left subtree of one side with right subtree of the other side. <br>
 * - At each pair, enforce both value equality and mirrored child ordering.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes in the tree.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth bounded by tree height.
 */
public class LeetCode0101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSameTree(root.left, root.right);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }

}
