package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree">LeetCode 654: Maximum Binary Tree</a>
 * <p>
 * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm: <br>
 * Return the maximum binary tree built from nums.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Monotonic stack. <br>
 * - Use a decreasing stack to link nodes as left/right children. <br>
 * - The last popped node becomes the left child of the current node.
 * <p>
 * Time Complexity: O(n) <br>
 * - Each element is pushed and popped at most once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack stores nodes.
 */
public class LeetCode0654_2 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        var stack = new ArrayDeque<TreeNode>();

        for (int num : nums) {
            TreeNode cur = new TreeNode(num);

            while (!stack.isEmpty() && stack.peek().val < num) {
                cur.left = stack.pop();
            }

            if (!stack.isEmpty()) {
                stack.peek().right = cur;
            }

            stack.push(cur);
        }

        TreeNode root = null;
        while (!stack.isEmpty()) {
            root = stack.pop();
        }

        return root;
    }

}
