package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree">LeetCode 543: Diameter of Binary Tree</a>
 * <p>
 * Approach: DFS computing subtree heights. <br>
 * - For each node, compute left and right heights. <br>
 * - Update the maximum diameter as left + right.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
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
