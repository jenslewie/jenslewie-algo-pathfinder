package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">LeetCode 129: Sum Root to Leaf Numbers</a>
 * <p>
 * You are given the root of a binary tree containing digits from 0 to 9 only.<br>
 * Each root-to-leaf path in the tree represents a number.<br>
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.<br>
 * Return the total sum of all root-to-leaf numbers.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: DFS with integer arithmetic. <br>
 * - Pass accumulated number as parameter instead of string building. <br>
 * - More efficient than string manipulation approach.
 * <p>
 * Time Complexity: O(n) <br>
 * - Visit each node exactly once.
 * <p>
 * Space Complexity: O(h) <br>
 * - Recursion stack depth equals tree height. <br>
 * - Constant extra space per call frame.
 */
public class LeetCode0129_2 {

    private int ans;

    public int sumNumbers(TreeNode root) {
        ans = 0;
        traverse(root, 0);
        return ans;
    }

    private void traverse(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans += num;
            return;
        }
        traverse(root.left, num);
        traverse(root.right, num);
    }

}
