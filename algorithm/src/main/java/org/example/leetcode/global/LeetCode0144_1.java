package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal">LeetCode 144: Binary Tree Preorder Traversal</a>
 * <p>
 * Given the root of a binary tree, return the preorder traversal of its nodes' values. <br>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Recursive traversal with shared list. <br>
 * - Visit root, then left subtree, then right subtree. <br>
 * - Accumulate results in a list field.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
 */
public class LeetCode0144_1 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

}
