package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node">LeetCode 116: Populating Next Right Pointers in Each Node</a>
 * <p>
 * Approach: DFS connecting adjacent pairs. <br>
 * - Connect left->right within the same parent. <br>
 * - Connect across parents by linking right child to next left child.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
 */
public class LeetCode0116_2 {

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }

    private void traverse(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return;
        }

        node1.next = node2;
        traverse(node1.left, node1.right);
        traverse(node1.right, node2.left);
        traverse(node2.left, node2.right);
    }

}
