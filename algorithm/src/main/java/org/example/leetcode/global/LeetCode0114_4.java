package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list">...</a>
 * Time Complexity: O(n)
 * Space Complexity: O(h), where h is the height of the tree (O(n) in worst case)
 */
public class LeetCode0114_4 {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeBuilder.buildTree(new Integer[]{1, 2, 5, 3, 4, null, 6}, 0);
        LeetCode0114_4 sol = new LeetCode0114_4();
        sol.flatten(root);
        System.out.println();
    }

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);

        if (left != null) {
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return right != null ? right : left != null ? left : root;
    }

}
