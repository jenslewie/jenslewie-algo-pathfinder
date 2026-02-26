package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

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
 * Approach: DFS recovery with hash-set membership storage. <br>
 * - Rebuild correct node values using parent-to-child formulas while traversing tree. <br>
 * - Insert each recovered value into set so find(target) becomes constant-time lookup.
 * <p>
 * Time Complexity: O(n) build, O(1) average find <br>
 * - n: nodes visited during recovery.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stores all recovered node values in hash set.
 */
public class LeetCode1261_2 {

    private final Set<Integer> set;

    public LeetCode1261_2(TreeNode root) {
        set = new HashSet<>();
        traverse(root, 0);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    private void traverse(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        node.val = val;
        set.add(node.val);
        traverse(node.left, node.val * 2 + 1);
        traverse(node.right, node.val * 2 + 2);
    }

}
