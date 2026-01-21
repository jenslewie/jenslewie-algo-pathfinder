package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree">...</a>
 */
public class LeetCode0543 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return ans;
    }

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);
        int diameter = left + right;
        ans = Math.max(ans, diameter);
        return Math.max(left, right) + 1;
    }

}
