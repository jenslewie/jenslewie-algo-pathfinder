package org.example.leetcode.global;

import org.example.model.tree.NaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-postorder-traversal">LeetCode 590: N-ary Tree Postorder Traversal</a>
 * <p>
 * Approach: DFS recursion. <br>
 * - Recursively traverse all children, then visit the root. 
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
 */
public class LeetCode0590 {
    private final List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(NaryTreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        for (NaryTreeNode node : root.children) {
            postorder(node);
        }
        result.add(root.value);

        return result;
    }
}
