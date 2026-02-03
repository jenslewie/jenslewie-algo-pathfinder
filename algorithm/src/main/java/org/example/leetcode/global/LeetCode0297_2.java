package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree">LeetCode 297: Serialize and Deserialize Binary Tree</a>
 * <p>
 * Approach: Postorder DFS with null markers. <br>
 * - Serialize left-right-root and use "#" for nulls. <br>
 * - Deserialize by consuming tokens from the end.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is processed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Serialized string plus recursion stack.
 */
public class LeetCode0297_2 {
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

        _serialize(node.left, sb);
        _serialize(node.right, sb);
        sb.append(node.val).append(SEPARATOR);
    }

    private TreeNode _deserialize(LinkedList<String> nodes) {
        String value = nodes.pollLast();
        if (NULL.equals(value)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.right = _deserialize(nodes);
        root.left = _deserialize(nodes);
        return root;
    }

}
