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
 * - Compare left and right subtree heights to determine if one side is perfect. <br>
 * - Use 2^h counts for perfect subtrees and recurse into the other side.
 * <p>
 * Time Complexity: O(log(n) * log(n)) <br>
 * - Each recursion computes heights in O(log(n)), and recursion depth is O(log(n)).
 * <p>
 * Space Complexity: O(log(n)) <br>
 * - Recursion depth on a complete tree.
 */
public class LeetCode0222_4 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeHeight = getHeight(root.left);
        int rightTreeHeight = getHeight(root.right);
        if (leftTreeHeight == rightTreeHeight) {
            return (1 << leftTreeHeight) + countNodes(root.right);
        }
        return countNodes(root.left) + (1 << rightTreeHeight);
    }

    private int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }

}
