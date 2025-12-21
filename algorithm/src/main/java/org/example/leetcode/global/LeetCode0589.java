package org.example.leetcode.global;

import org.example.model.tree.NaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-ary-tree-preorder-traversal/
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
