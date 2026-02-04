package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree">LeetCode 111: Minimum Depth of Binary Tree</a>
 * <p>
 * Given a binary tree, find its minimum depth. <br>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node. <br>
 * Note: A leaf is a node with no children.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: BFS level-order traversal. <br>
 * - Visit nodes level by level. <br>
 * - The first leaf encountered defines the minimum depth.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(w) <br>
 * - w: maximum width of the tree held in the queue.
 */
public class LeetCode0111_1 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (true) {
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
    }
}
