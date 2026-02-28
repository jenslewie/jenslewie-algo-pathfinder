package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/same-tree">LeetCode 100: Same Tree</a>
 * <p>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not. <br>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Recursive synchronized traversal of both trees. <br>
 * - Compare current nodes for null/equality first. <br>
 * - Recurse into left and right children only when current nodes match.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes visited across both trees until mismatch or completion.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth bounded by tree height.
 */
public class LeetCode0100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
