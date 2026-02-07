package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree">LeetCode 1457: Pseudo-Palindromic Paths in a Binary Tree</a>
 * <p>
 * Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome. <br>
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: DFS with fixed array counts. <br>
 * - Use an int[10] to track digit frequencies along the path and validate at leaves. <br>
 * - Backtrack the count when returning from recursion.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once and the leaf check scans up to 9 counts.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth; count array is size 10.
 */
public class LeetCode1457_2 {

    private int ans;

    public int pseudoPalindromicPaths(TreeNode root) {
        ans = 0;
        int[] count = new int[10];
        traverse(root, count);
        return ans;
    }

    private void traverse(TreeNode node, int[] count) {
        if (node == null) {
            return;
        }
        count[node.val]++;
        if (node.left == null && node.right == null) {
            if (isPalindrome(count)) {
                ans++;
            }
            count[node.val]--;
            return;
        }
        traverse(node.left, count);
        traverse(node.right, count);
        count[node.val]--;
    }

    private boolean isPalindrome(int[] count) {
        int odd = 0;
        for (int num : count) {
            if (num % 2 == 1) {
                odd++;
            }
            if (odd == 2) {
                return false;
            }
        }
        return true;
    }

}
