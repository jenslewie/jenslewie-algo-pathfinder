package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list">...</a>
 * Time Complexity: O(n)
 * Space Complexity: O(h), where h is the height of the tree (O(n) in worst case)
 */
public class LeetCode0114_3 {

    private TreeNode head;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = head;
        head = root;
    }

}
