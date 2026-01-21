package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal">...</a>
 */
public class LeetCode0144_2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        var ans = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }

        ans.add(root.val);
        ans.addAll(preorderTraversal(root.left));
        ans.addAll(preorderTraversal(root.right));
        return ans;
    }

}
