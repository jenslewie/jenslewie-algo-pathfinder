package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree">LeetCode 297: Serialize and Deserialize Binary Tree</a>
 * <p>
 * Approach: Preorder DFS with null markers. <br>
 * - Serialize with root-left-right and use "#" for nulls. <br>
 * - Deserialize by consuming tokens in preorder.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is processed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Serialized string plus recursion stack.
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
        if (data == null || data.isEmpty()) {
            return null;
        }
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
