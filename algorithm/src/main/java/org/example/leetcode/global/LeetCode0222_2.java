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
 * Approach: Recursive traversal. <br>
 * - Count nodes by summing the left and right subtree sizes plus one for the current node.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth in the worst case.
 */
public class LeetCode0222_2 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
