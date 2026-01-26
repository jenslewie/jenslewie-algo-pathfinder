package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree">...</a>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
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
