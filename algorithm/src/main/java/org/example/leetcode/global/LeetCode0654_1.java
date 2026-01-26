package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree">...</a>
 * Time Complexity: O(n^2)
 * - In the worst case (monotonically increasing or decreasing array),
 * each recursive call scans the entire subarray to find the maximum,
 * leading to n + (n-1) + ... + 1 operations.
 * Space Complexity: O(n)
 * - Due to recursion stack in the worst case when the tree is skewed.
 * - (Best case would be O(log n) if the tree is balanced.)
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
