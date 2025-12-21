package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 */
public class LeetCode0111 {
    private int minDepth = Integer.MAX_VALUE;
    private int currentDepth = 0;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }

        return depth;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return minDepth;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        currentDepth++;
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, currentDepth);
        }
        traverse(root.left);
        traverse(root.right);
        currentDepth--;
    }

}
