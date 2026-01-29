package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree">...</a>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LeetCode0297_1 {
    private final static String SEPARATOR = ",";
    private final static String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        _serialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        var nodes = new LinkedList<>(Arrays.asList(data.split(SEPARATOR)));
        return _deserialize(nodes);
    }

    private void _serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SEPARATOR);
            return;
        }

        sb.append(node.val).append(SEPARATOR);
        _serialize(node.left, sb);
        _serialize(node.right, sb);
    }

    private TreeNode _deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String value = nodes.pollFirst();
        if (NULL.equals(value)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = _deserialize(nodes);
        root.right = _deserialize(nodes);
        return root;
    }

}
