package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 */
public class LeetCode0111_1 {

    /**
     * BFS (Breadth-First Search) approach
     * Time Complexity: O(n)
     * - n: number of nodes in the tree
     * - We visit each node at most once
     * <p>
     * Space Complexity: O(w)
     * - w: maximum width of the tree (at any level)
     * - Queue can hold up to w nodes in the worst case
     */
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
}