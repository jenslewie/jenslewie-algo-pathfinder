package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">LeetCode 199: Binary Tree Right Side View</a>
 * <p>
 * Given the root of a binary tree, imagine yourself standing on the right side of it,<br>
 * return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: DFS with right-first traversal. <br>
 * - Visit right child before left child. <br>
 * - Record first node encountered at each depth level.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; visit each node once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree; recursion stack depth.
 */
public class LeetCode0199_2 {

    public List<Integer> rightSideView(TreeNode root) {
        var ans = new ArrayList<Integer>();
        traverse(root, 0, ans);
        return ans;
    }

    private void traverse(TreeNode node, int depth, List<Integer> ans) {
        if (node == null) {
            return;
        }
        if (depth == ans.size()) {
            ans.add(node.val);
        }
        traverse(node.right, depth + 1, ans);
        traverse(node.left, depth + 1, ans);
    }

}
