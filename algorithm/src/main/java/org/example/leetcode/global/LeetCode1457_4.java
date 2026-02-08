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
 * Approach: DFS with bitmask optimization. <br>
 * - Use bitmask where each bit represents the parity of a digit (1-9). <br>
 * - XOR toggles bits when visiting nodes, efficiently tracking odd/even counts. <br>
 * - At leaves, check if mask has at most one bit set using bit trick (mask & (mask-1)).
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once with constant time operations.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth; only integer mask passed through recursion.
 */
public class LeetCode1457_4 {

    public int pseudoPalindromicPaths(TreeNode root) {
        return traverse(root, 0);
    }

    private int traverse(TreeNode node, int mask) {
        if (node == null) {
            return 0;
        }
        mask ^= 1 << node.val;
        if (node.left == null && node.right == null) {
            return (mask & (mask - 1)) == 0 ? 1 : 0;
        }
        return traverse(node.left, mask) + traverse(node.right, mask);
    }

}
