package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal">...</a>
 */
public class LeetCode0144_1 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

}
