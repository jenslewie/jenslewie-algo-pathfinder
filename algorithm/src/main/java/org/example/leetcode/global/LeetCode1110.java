package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/delete-nodes-and-return-forest">LeetCode 1110: Delete Nodes And Return Forest</a>
 * <p>
 * Given the root of a binary tree, each node in the tree has a distinct value. <br>
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees). <br>
 * Return the roots of the trees in the remaining forest. You may return the result in any order.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Postorder DFS with delete-set filtering. <br>
 * - Recursively process children first so each subtree is already cleaned when visiting parent. <br>
 * - If current node is deleted, promote non-null children as new forest roots; otherwise keep node.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: each node is visited once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stores delete set plus recursion stack in worst-case skewed tree.
 */
public class LeetCode1110 {

    private List<TreeNode> ans;
    private Set<Integer> set;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        this.ans = new ArrayList<>();
        this.set = new HashSet<>();
        for (int i : to_delete) {
            this.set.add(i);
        }
        if (traverse(root) != null) {
            ans.add(root);
        }
        return ans;
    }

    private TreeNode traverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        node.left = traverse(node.left);
        node.right = traverse(node.right);
        if (!set.contains(node.val)) {
            return node;
        }
        if (node.left != null) {
            ans.add(node.left);
        }
        if (node.right != null) {
            ans.add(node.right);
        }
        return null;
    }

}
