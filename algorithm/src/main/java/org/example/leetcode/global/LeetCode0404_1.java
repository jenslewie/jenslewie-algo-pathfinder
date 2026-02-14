package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/sum-of-left-leaves">LeetCode 404: Sum of Left Leaves</a>
 * <p>
 * Given the root of a binary tree, return the sum of all left leaves. <br>
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: DFS traversal with direct left-leaf check. <br>
 * - At each node, if left child exists and is a leaf, add its value to the sum. <br>
 * - Continue traversing both subtrees to collect all left leaves.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion stack depth for tree height.
 */
public class LeetCode0404_1 {

    private int ans;

    public int sumOfLeftLeaves(TreeNode root) {
        ans = 0;
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.left.left == null && node.left.right == null) {
            ans += node.left.val;
        }
        traverse(node.left);
        traverse(node.right);
    }

}
