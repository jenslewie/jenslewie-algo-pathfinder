package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-paths">LeetCode 257: Binary Tree Paths</a>
 * <p>
 * Given the root of a binary tree, return all root-to-leaf paths in any order. <br>
 * A leaf is a node with no children.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Recursive DFS with StringBuilder backtracking. <br>
 * - Use a shared StringBuilder to avoid repeated string concatenation. <br>
 * - Backtrack after visiting each node.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion.
 */
public class LeetCode0257_3 {

    public List<String> binaryTreePaths(TreeNode root) {
        var ans = new ArrayList<String>();
        traverse(root, new StringBuilder(), ans);
        return ans;
    }

    private void traverse(TreeNode root, StringBuilder path, List<String> ans) {
        if (root == null) {
            return;
        }
        int len = path.length();
        path.append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(path.toString());
        } else {
            path.append("->");
            traverse(root.left, path, ans);
            traverse(root.right, path, ans);
        }
        path.setLength(len);
    }

}
