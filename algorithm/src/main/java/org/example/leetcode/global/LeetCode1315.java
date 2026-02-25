package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent">LeetCode 1315: Sum of Nodes with Even-Valued Grandparent</a>
 * <p>
 * Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0. <br>
 * A grandparent of a node is the parent of its parent if it exists.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: DFS traversal carrying parent and grandparent references. <br>
 * - At each node, add value if grandparent exists and is even. <br>
 * - Recurse while shifting current node into parent/grandparent positions.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: total number of visited nodes.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth equals tree height.
 */
public class LeetCode1315 {

    private int ans;

    public int sumEvenGrandparent(TreeNode root) {
        ans = 0;
        traverse(root, null, null);
        return ans;
    }

    private void traverse(TreeNode node, TreeNode parentNode, TreeNode grandParentNode) {
        if (node == null) {
            return;
        }
        if (grandParentNode != null && grandParentNode.val % 2 == 0) {
            ans += node.val;
        }
        traverse(node.left, node, parentNode);
        traverse(node.right, node, parentNode);
    }

}
