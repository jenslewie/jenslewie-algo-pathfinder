package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal">LeetCode 889: Construct Binary Tree from Preorder and Postorder Traversal</a>
 * <p>
 * Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree. <br>
 * If there exist multiple answers, you can return any of them.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Recursion with index map. <br>
 - Use preorder root and postorder to split subtrees. <br>
 - Recurse on left and right ranges.
 * <p>
 * Time Complexity: O(n) <br>
 * - Each node is constructed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Map plus recursion stack.
 */
public class LeetCode0889 {

    private final Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        return dfs(preorder, 0, n, 0, n);
    }

    private TreeNode dfs(int[] preorder, int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft == preRight) {
            return null;
        }
        if (preLeft + 1 == preRight) {
            return new TreeNode(preorder[preLeft]);
        }

        int leftRootIndex = preLeft + 1;
        int leftSize = map.get(preorder[leftRootIndex]) + 1 - postLeft;
        TreeNode left = dfs(preorder, leftRootIndex, leftRootIndex + leftSize, postLeft, postLeft + leftSize);
        TreeNode right = dfs(preorder, leftRootIndex + leftSize, preRight, postLeft + leftSize, postRight - 1);
        return new TreeNode(preorder[preLeft], left, right);
    }

}
