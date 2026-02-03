package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal">LeetCode 105: Construct Binary Tree from Preorder and Inorder Traversal</a>
 * <p>
 * Approach: Recursive split with array copies. <br>
 * - Use the preorder root to split the inorder array. <br>
 * - Recurse on left and right subarrays created by copying ranges.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - Each recursion searches the root in inorder and copies subarrays.
 * <p>
 * Space Complexity: O(n^2) <br>
 * - Subarray copies across recursion levels dominate space.
 */
public class LeetCode0105_1 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int leftSize = indexOf(inorder, preorder[0]);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] preorderRight = Arrays.copyOfRange(preorder, 1 + leftSize, preorder.length);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] inorderRight = Arrays.copyOfRange(inorder, leftSize + 1, inorder.length);

        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        return root;
    }

    private int indexOf(int[] inorder, int x) {
        int i = 0;
        while (true) {
            if (inorder[i] == x) {
                return i;
            }
            i++;
        }
    }

}
