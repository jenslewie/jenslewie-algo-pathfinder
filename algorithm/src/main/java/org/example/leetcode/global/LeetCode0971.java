package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal">LeetCode 971: Flip Binary Tree To Match Preorder Traversal</a>
 * <p>
 * You are given the root of a binary tree with n nodes, where each node is uniquely assigned a value from 1 to n. You are also given a sequence of n values voyage, which is the desired pre-order traversal of the binary tree. <br>
 * Any node in the binary tree can be flipped by swapping its left and right subtrees. For example, flipping node 1 will have the following effect: <br>
 * Flip the smallest number of nodes so that the pre-order traversal of the tree matches voyage. <br>
 * Return a list of the values of all flipped nodes. You may return the answer in any order. If it is impossible to flip the nodes in the tree to make the pre-order traversal match voyage, return the list [-1].
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Preorder DFS with conditional child flip. <br>
 * - Match nodes against voyage using a moving preorder index. <br>
 * - If next expected value does not match left child, record flip and traverse right before left.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion stack for tree height.
 */
public class LeetCode0971 {
    private List<Integer> ans;
    private int index;
    private boolean failed;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        ans = new ArrayList<>();
        index = 0;
        failed = false;

        traverse(root, voyage);
        return failed ? List.of(-1) : ans;
    }

    private void traverse(TreeNode node, int[] voyage) {
        if (node == null || failed) {
            return;
        }

        if (node.val != voyage[index++]) {
            failed = true;
            return;
        }

        if (index < voyage.length && node.left != null && node.left.val != voyage[index]) {
            ans.add(node.val);
            traverse(node.right, voyage);
            traverse(node.left, voyage);
        } else {
            traverse(node.left, voyage);
            traverse(node.right, voyage);
        }
    }

}
