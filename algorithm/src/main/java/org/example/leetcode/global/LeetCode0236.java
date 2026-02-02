package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree">LeetCode 236: Lowest Common Ancestor of a Binary Tree</a>
 * <p>
 * This implementation uses a recursive post-order traversal to find the LCA.
 * The algorithm searches for nodes p and q in the tree, and returns their lowest common ancestor.
 * <p>
 * Time Complexity: O(n)
 * - In the worst case, we need to visit all n nodes of the binary tree.
 * - This occurs when both p and q are in the same subtree, requiring full traversal.
 * <p>
 * Space Complexity: O(h)
 * - Where h is the height of the binary tree, due to the recursion call stack.
 * - In the worst case (skewed tree), h = n, so space complexity becomes O(n).
 * - In the best case (balanced tree), h = log n, so space complexity is O(log n).
 */
public class LeetCode0236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }

}
