package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-iv">LeetCode 1676: Lowest Common Ancestor of a Binary Tree IV</a>
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Postorder DFS with target set. <br>
 * - Return current node if it is a target or both children report a target. <br>
 * - Otherwise propagate the non-null child result upward.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(m + h) <br>
 * - m: number of target nodes; h: height of the tree.
 */
public class LeetCode1676 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        var set = new HashSet<Integer>();
        for (var node : nodes) {
            set.add(node.val);
        }
        return LCA(root, set);
    }

    private TreeNode LCA(TreeNode root, HashSet<Integer> set) {
        if (root == null || set.contains(root.val)) {
            return root;
        }
        var left = LCA(root.left, set);
        var right = LCA(root.right, set);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left != null ? left : right;
    }

}
