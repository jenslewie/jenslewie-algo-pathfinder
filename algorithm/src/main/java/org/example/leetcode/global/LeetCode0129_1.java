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
 * Approach: DFS with StringBuilder for path tracking. <br>
 * - Use StringBuilder to build the number string during traversal. <br>
 * - Backtrack by restoring the StringBuilder length after recursive calls.
 * <p>
 * Time Complexity: O(n) <br>
 * - Visit each node exactly once.
 * <p>
 * Space Complexity: O(h) <br>
 * - Recursion stack depth equals tree height. <br>
 * - StringBuilder storage proportional to path length.
 */
public class LeetCode0129_1 {

    private int ans;

    public int sumNumbers(TreeNode root) {
        ans = 0;
        traverse(root, new StringBuilder());
        return ans;
    }

    private void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            ans += Integer.parseInt(sb.toString());
        } else {
            traverse(root.left, sb);
            traverse(root.right, sb);
        }
        sb.setLength(len);
    }

}
