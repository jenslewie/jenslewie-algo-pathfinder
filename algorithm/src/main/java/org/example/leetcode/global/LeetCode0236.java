package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree">LeetCode 236: Lowest Common Ancestor of a Binary Tree</a>
 * <p>
 * Approach: Recursive postorder search. <br>
 * - Recurse on left and right subtrees to find p and q. <br>
 * - If both sides return non-null, the current node is the LCA.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
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
