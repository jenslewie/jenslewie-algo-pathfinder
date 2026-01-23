package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree">...</a>
 */
public class LeetCode0226_2 {

    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;

        traverse(node.left);
        traverse(node.right);
    }

}
