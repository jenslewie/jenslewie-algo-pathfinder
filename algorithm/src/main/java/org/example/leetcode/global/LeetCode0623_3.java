package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.com/problems/add-one-row-to-tree">LeetCode 623: Add One Row to Tree</a>
 * <p>
 * Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth. <br>
 * Note that the root node is at depth 1. <br>
 * The adding rule is: <br>
 * Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root. <br>
 * cur's original left subtree should be the left subtree of the new left subtree root. <br>
 * cur's original right subtree should be the right subtree of the new right subtree root. <br>
 * If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: BFS level-order insertion at target depth. <br>
 * - Use a queue to scan level by level until reaching the target parent depth. <br>
 * - For each node at that depth, insert new nodes and reconnect original subtrees.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes processed across levels.
 * <p>
 * Space Complexity: O(w) <br>
 * - w: maximum queue size at one level (tree width).
 */
public class LeetCode0623_3 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }

        var queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        int currentDepth = 2;
        while (!queue.isEmpty() && currentDepth <= depth) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
                if (depth == currentDepth) {
                    node.left = new TreeNode(val, node.left, null);
                    node.right = new TreeNode(val, null, node.right);
                }
            }
            currentDepth++;
        }

        return root;
    }

}
