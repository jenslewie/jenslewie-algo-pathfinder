package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-bottom-left-tree-value">LeetCode 513: Find Bottom Left Tree Value</a>
 * <p>
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: DFS preorder with first-value map by depth. <br>
 * - Visit left child before right child so the first value seen at each depth is leftmost. <br>
 * - Track maximum depth reached and return stored value for that depth.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth, plus up to h map entries by depth.
 */
public class LeetCode0513_2 {

    private Map<Integer, Integer> map;
    private int maxDepth;

    public int findBottomLeftValue(TreeNode root) {
        map = new HashMap<>();
        maxDepth = 0;
        traverse(root, 0);
        return map.get(maxDepth);
    }

    private void traverse(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        maxDepth = Math.max(maxDepth, depth);
        if (!map.containsKey(depth)) {
            map.put(depth, node.val);
        }
        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
    }

}
