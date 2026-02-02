package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-iv">LeetCode 1676: LCA of Binary Tree IV</a>
 * <p>
 * Given a binary tree and an array of target nodes, find their lowest common ancestor (LCA).<br>
 * Assumption: All node values in the tree are unique (as per LeetCode 1676 constraint).
 * <p>
 * Time Complexity: O(n)<br>
 * - Each node is visited at most once during the post-order traversal.
 * <p>
 * Space Complexity: O(m + h)<br>
 * - m: number of target nodes (for the HashSet)<br>
 * - h: height of the tree (for recursion stack; worst case O(n), best case O(log n))
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
