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
 * Approach: Recursive DFS with string accumulation. <br>
 * - Build path as a string and append when reaching a leaf.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion.
 */
public class LeetCode0257_2 {

    public List<String> binaryTreePaths(TreeNode root) {
        var ans = new ArrayList<String>();
        traverse(root, "", ans);
        return ans;
    }

    private void traverse(TreeNode root, String path, List<String> ans) {
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }
        path += "->";
        traverse(root.left, path, ans);
        traverse(root.right, path, ans);
    }

}
