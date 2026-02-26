package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree">LeetCode 1261: Find Elements in a Contaminated Binary Tree</a>
 * <p>
 * Given a binary tree with the following rules: <br>
 * root.val == 0 <br>
 * For any treeNode: <br>
 * If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1 <br>
 * If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2 <br>
 * Now the binary tree is contaminated, which means all treeNode.val have been changed to -1. <br>
 * Implement the FindElements class: <br>
 * FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it. <br>
 * bool find(int target) Returns true if the target value exists in the recovered binary tree.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: DFS recovery with direct boolean-array membership index. <br>
 * - Recover contaminated values with root=0 and child formulas 2x+1 / 2x+2. <br>
 * - Mark recovered values in fixed-size array for O(1) find queries.
 * <p>
 * Time Complexity: O(n) build, O(1) find <br>
 * - n: number of nodes recovered during constructor traversal.
 * <p>
 * Space Complexity: O(U) <br>
 * - U: fixed upper bound array size for value domain.
 */
public class LeetCode1261_1 {

    private final int[] nums = new int[1048576];

    public LeetCode1261_1(TreeNode root) {
        traverse(root, 0);
    }

    public boolean find(int target) {
        return nums[target] == 1;
    }

    private void traverse(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        node.val = val;
        nums[node.val] = 1;
        traverse(node.left, node.val * 2 + 1);
        traverse(node.right, node.val * 2 + 2);
    }

}
