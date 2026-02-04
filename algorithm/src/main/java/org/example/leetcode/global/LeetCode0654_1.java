package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree">LeetCode 654: Maximum Binary Tree</a>
 * <p>
 * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm: <br>
 * Return the maximum binary tree built from nums.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Recursive scan for maximum. <br>
 * - Find the maximum element as root. <br>
 * - Recurse on left and right subarrays.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - Worst case when the array is monotonic and each scan is linear.
 * <p>
 * Space Complexity: O(n) <br>
 * - Recursion depth in the worst case (skewed tree).
 */
public class LeetCode0654_1 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int index = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }

        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums, left, index - 1);
        root.right = build(nums, index + 1, right);

        return root;
    }

}
