package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/smallest-string-starting-from-leaf/">LeetCode 988: Smallest String Starting From Leaf</a>
 * <p>
 * You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.<br>
 * Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.<br>
 * As a reminder, any shorter prefix of a string is lexicographically smaller.<br>
 * For example, "ab" is lexicographically smaller than "aba".
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: DFS with backtracking. <br>
 * - Traverse from root to leaves, building string path. <br>
 * - At each leaf, reverse the path and compare with current minimum. <br>
 * - Use backtracking to restore path after recursive calls.
 * <p>
 * Time Complexity: O(n²) <br>
 * - n: number of nodes; each path comparison takes O(path_length).
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of tree; recursion stack and path storage.
 */
public class LeetCode0988 {

    private String ans;

    public String smallestFromLeaf(TreeNode root) {
        ans = null;
        var path = new StringBuilder();
        traverse(root, path);
        return ans;
    }

    private void traverse(TreeNode node, StringBuilder path) {
        if (node == null) {
            return;
        }
        int len = path.length();
        path.append(convert(node.val));
        if (node.left == null && node.right == null) {
            String temp = path.reverse().toString();
            if (ans == null || ans.compareTo(temp) > 0) {
                ans = temp;
            }
            path.reverse();
        } else {
            traverse(node.left, path);
            traverse(node.right, path);
        }
        path.setLength(len);
    }

    private char convert(int num) {
        return (char) ('a' + num);
    }

}
