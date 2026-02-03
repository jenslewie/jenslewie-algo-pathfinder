package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree">LeetCode 104: Maximum Depth of Binary Tree</a>
 * <p>
 * Approach: DFS traversal with depth tracking. <br>
 * - Traverse the tree while tracking current depth. <br>
 * - Update the maximum when a leaf is reached.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
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
