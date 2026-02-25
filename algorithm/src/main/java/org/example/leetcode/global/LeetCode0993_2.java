package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/cousins-in-binary-tree">LeetCode 993: Cousins in Binary Tree</a>
 * <p>
 * Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise. <br>
 * Two nodes of a binary tree are cousins if they have the same depth with different parents. <br>
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: DFS traversal recording parent and depth of targets. <br>
 * - Traverse tree once and capture parent/depth for x and y when encountered. <br>
 * - Cousins condition is same depth with different parents.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: each node is visited at most once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion stack height.
 */
public class LeetCode0993_2 {

    private TreeNode parentX;
    private TreeNode parentY;
    private int depthX;
    private int depthY;

    public boolean isCousins(TreeNode root, int x, int y) {
        parentX = null;
        parentY = null;
        depthX = -1;
        depthY = -1;
        traverse(null, root, x, y, 0);
        return depthX == depthY && parentX != parentY;
    }

    private void traverse(TreeNode parentNode, TreeNode node, int x, int y, int depth) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            parentX = parentNode;
            depthX = depth;
        } else if (node.val == y) {
            parentY = parentNode;
            depthY = depth;
        }
        traverse(node, node.left, x, y, depth + 1);
        traverse(node, node.right, x, y, depth + 1);
    }

}
