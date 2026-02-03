package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal">LeetCode 144: Binary Tree Preorder Traversal</a>
 * <p>
 * Approach: Iterative stack. <br>
 * - Push root, then pop to visit and push right then left. <br>
 * - Ensures preorder order without recursion.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is processed once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree; stack stores at most one path.
 */
public class LeetCode0144_3 {

    public List<Integer> preorderTraversal(TreeNode root) {
        var ans = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }

        var stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return ans;
    }

}
