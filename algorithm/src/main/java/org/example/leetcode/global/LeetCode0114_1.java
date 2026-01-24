package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list">...</a>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LeetCode0114_1 {

    private final Queue<TreeNode> queue = new LinkedList<>();

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root);
        root = queue.poll();
        TreeNode p = root;
        while (!queue.isEmpty()) {
            p.right = queue.poll();
            p.left = null;
            p = p.right;
        }
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        queue.offer(root);
        traverse(root.left);
        traverse(root.right);
    }

}
