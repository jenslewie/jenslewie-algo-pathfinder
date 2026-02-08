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
 * Approach: DFS with bit manipulation optimization. <br>
 * - Use XOR operation to track parity of digit counts along the path. <br>
 * - At leaf nodes, check if at most one bit is set (indicating at most one odd count).
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth; constant space for count array.
 */
public class LeetCode1457_3 {

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] count = new int[10];
        return traverse(root, count);
    }

    private int traverse(TreeNode node, int[] count) {
        if (node == null) {
            return 0;
        }
        count[node.val] ^= 1;
        int ans = 0;
        if (node.left == null && node.right == null) {
            if (isPalindromic(count)) {
                ans++;
            }
        } else {
            ans = traverse(node.left, count) + traverse(node.right, count);
        }
        count[node.val] ^= 1;
        return ans;
    }

    private boolean isPalindromic(int[] count) {
        int oddCount = 0;
        for (int c : count) {
            oddCount += c;
        }
        return oddCount <= 1;
    }

}
