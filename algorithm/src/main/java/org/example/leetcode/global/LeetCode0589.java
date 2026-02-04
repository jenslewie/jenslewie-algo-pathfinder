package org.example.leetcode.global;

import org.example.model.tree.NaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-preorder-traversal">LeetCode 589: N-ary Tree Preorder Traversal</a>
 * <p>
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values. <br>
 * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples) <br>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: DFS recursion. <br>
 * - Visit root first, then recursively traverse children from left to right.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
 */
public class LeetCode0589 {
    private final List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(NaryTreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        result.add(root.value);

        for (NaryTreeNode node : root.children) {
            preorder(node);
        }

        return result;
    }
}
