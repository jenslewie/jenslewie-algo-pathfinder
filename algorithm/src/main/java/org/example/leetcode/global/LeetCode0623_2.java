package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/add-one-row-to-tree">LeetCode 623: Add One Row to Tree</a>
 * <p>
 * Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth. <br>
 * Note that the root node is at depth 1. <br>
 * The adding rule is: <br>
 * Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root. <br>
 * cur's original left subtree should be the left subtree of the new left subtree root. <br>
 * cur's original right subtree should be the right subtree of the new right subtree root. <br>
 * If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Recursive divide-and-conquer by remaining depth. <br>
 * - Reduce depth recursively until the insertion layer is reached. <br>
 * - At depth 2, attach new nodes and reconnect original children beneath them.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion stack depth along tree height.
 */
public class LeetCode0623_2 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
        }
        return root;
    }

}
