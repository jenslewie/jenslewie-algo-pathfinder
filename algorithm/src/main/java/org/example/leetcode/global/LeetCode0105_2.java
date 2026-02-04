package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal">LeetCode 105: Construct Binary Tree from Preorder and Inorder Traversal</a>
 * <p>
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Recursion with inorder index map. <br>
 * - Map each inorder value to its index for O(1) splits. <br>
 * - Recurse using index ranges without copying arrays.
 * <p>
 * Time Complexity: O(n) <br>
 * - Each node is processed once with O(1) index lookup.
 * <p>
 * Space Complexity: O(n) <br>
 * - Map storage plus recursion stack.
 */
public class LeetCode0105_2 {

    private final Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, n, 0);
    }

    private TreeNode dfs(int[] preorder, int preorderLeft, int preorderRight, int inorderLeft) {
        if (preorderLeft == preorderRight) {
            return null;
        }
        int leftSize = map.get(preorder[preorderLeft]) - inorderLeft;
        TreeNode left = dfs(preorder, preorderLeft + 1, preorderLeft + 1 + leftSize, inorderLeft);
        TreeNode right = dfs(preorder, preorderLeft + 1 + leftSize, preorderRight, inorderLeft + 1 + leftSize);
        return new TreeNode(preorder[preorderLeft], left, right);
    }

}
