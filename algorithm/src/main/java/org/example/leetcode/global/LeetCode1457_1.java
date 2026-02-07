package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree">LeetCode 1457: Pseudo-Palindromic Paths in a Binary Tree</a>
 * <p>
 * Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome. <br>
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: DFS with frequency map. <br>
 * - Track counts along the path and check at leaves if at most one digit has an odd count. <br>
 * - Backtrack counts when returning up the recursion.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once and the leaf check scans up to 9 counts.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth; map size is bounded by digits 1..9.
 */
public class LeetCode1457_1 {

    private int ans;

    public int pseudoPalindromicPaths(TreeNode root) {
        ans = 0;
        var path = new HashMap<Integer, Integer>();
        traverse(root, path);
        return ans;
    }

    private void traverse(TreeNode node, HashMap<Integer, Integer> path) {
        if (node == null) {
            return;
        }
        path.put(node.val, path.getOrDefault(node.val, 0) + 1);
        if (node.left == null && node.right == null) {
            if (isPalindrome(path)) {
                ans++;
            }
        }
        traverse(node.left, path);
        traverse(node.right, path);
        path.put(node.val, path.get(node.val) - 1);
    }

    private boolean isPalindrome(HashMap<Integer, Integer> path) {
        int odd = 0;
        for (int value : path.values()) {
            if (value % 2 == 1) {
                odd++;
            }
            if (odd == 2) {
                return false;
            }
        }
        return true;
    }

}
