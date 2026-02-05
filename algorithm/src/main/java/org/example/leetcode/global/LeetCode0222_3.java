package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/count-complete-tree-nodes">LeetCode 222: Count Complete Tree Nodes</a>
 * <p>
 * Given the root of a complete binary tree, return the number of the nodes in the tree. <br>
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all
 * nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h. <br>
 * Design an algorithm that runs in less than O(n) time complexity.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Height-based divide and conquer. <br>
 * - Compare leftmost and rightmost heights to detect a perfect subtree. <br>
 * - If perfect, return 2^h - 1; otherwise recurse on children.
 * <p>
 * Time Complexity: O(log(n) * log(n)) <br>
 * - Each level computes heights in O(log(n)), and recursion depth is O(log(n)).
 * <p>
 * Space Complexity: O(log(n)) <br>
 * - Recursion depth for an unbalanced last level.
 */
public class LeetCode0222_3 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode leftSubTree = root, rightSubTree = root;
        int leftTreeHeight = 0, rightTreeHight = 0;
        while (rightSubTree != null) {
            rightSubTree = rightSubTree.right;
            rightTreeHight++;
        }
        while (leftSubTree != null) {
            leftSubTree = leftSubTree.left;
            leftTreeHeight++;
        }
        if (leftTreeHeight == rightTreeHight) {
            return (int) Math.pow(2, leftTreeHeight) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
