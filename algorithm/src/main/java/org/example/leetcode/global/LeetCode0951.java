package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/flip-equivalent-binary-trees">LeetCode 951: Flip Equivalent Binary Trees</a>
 * <p>
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees. <br>
 * A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations. <br>
 * Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Recursive equivalence check with no-flip/flip branching. <br>
 * - If current roots mismatch by nullness or value, return false immediately. <br>
 * - Otherwise, recursively validate either direct child pairing or flipped child pairing.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes when subtree comparisons prune quickly on mismatches.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth bounded by tree height.
 */
public class LeetCode0951 {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }

}
