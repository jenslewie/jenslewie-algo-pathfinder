package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree">LeetCode 235: Lowest Common Ancestor of a Binary Search Tree</a>
 * <p>
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST. <br>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the
 * lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Recursive BST traversal. <br>
 * - Recurse left or right when both targets are on the same side. <br>
 * - Otherwise current node is the LCA.
 * <p>
 * Time Complexity: O(h) <br>
 * - h: height of the BST; one path is traversed.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth in the worst case.
 */
public class LeetCode0235_2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

}
