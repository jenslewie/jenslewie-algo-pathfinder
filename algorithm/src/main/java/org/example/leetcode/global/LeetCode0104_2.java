package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree">...</a>
 */
public class LeetCode0104_2 {

    int depth = 0;
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return maxDepth;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

}
