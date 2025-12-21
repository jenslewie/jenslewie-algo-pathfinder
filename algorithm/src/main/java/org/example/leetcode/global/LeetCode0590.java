package org.example.leetcode.global;

import org.example.model.tree.NaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-ary-tree-postorder-traversal/
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
