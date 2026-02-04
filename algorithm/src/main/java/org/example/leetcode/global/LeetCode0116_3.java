package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node">LeetCode 116: Populating Next Right Pointers in Each Node</a>
 * <p>
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition: <br>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. <br>
 * Initially, all next pointers are set to NULL. <br>
 * Follow-up:
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Recursive connection using existing next pointers. <br>
 * - Link left->right and right->next.left as you traverse. <br>
 * - Recurse down the tree.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
 */
public class LeetCode0116_3 {

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
            connect(root.left);
            connect(root.right);
        }

        return root;
    }

}
