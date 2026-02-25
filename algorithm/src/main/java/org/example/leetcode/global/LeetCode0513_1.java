package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.com/problems/find-bottom-left-tree-value">LeetCode 513: Find Bottom Left Tree Value</a>
 * <p>
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: BFS level-order traversal capturing first node per level. <br>
 * - Traverse tree level by level with a queue. <br>
 * - The first node visited at each level is the leftmost; keep the value from the deepest level.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: each node is enqueued and dequeued once.
 * <p>
 * Space Complexity: O(w) <br>
 * - w: maximum queue size at a single level.
 */
public class LeetCode0513_1 {

    public int findBottomLeftValue(TreeNode root) {
        var queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        int ans = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (i == 0) {
                    ans = node.val;
                }
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
        }
        return ans;
    }

}
