package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree">LeetCode 226: Invert Binary Tree</a>
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Iterative stack traversal. <br>
 * - Use a stack to visit nodes. <br>
 * - Swap children for each popped node.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is processed once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree; stack holds a path of nodes.
 */
public class LeetCode0226_3 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        return root;
    }

}
