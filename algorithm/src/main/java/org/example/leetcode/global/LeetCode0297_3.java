package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree">...</a>
 * Time Complexity:
 * Space Complexity:
 */
public class LeetCode0297_3 {

    private final static String SEPARATOR = ",";
    private final static String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (node == null) {
                sb.append(NULL).append(SEPARATOR);
            } else {
                sb.append(node.val).append(SEPARATOR);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        var nodes = data.split(SEPARATOR);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty()) {
            var parent = queue.poll();
            var leftValue = nodes[index++];
            if (!NULL.equals(leftValue)) {
                parent.left = new TreeNode(Integer.parseInt(leftValue));
                queue.offer(parent.left);
            }
            var rightValue = nodes[index++];
            if (!NULL.equals(rightValue)) {
                parent.right = new TreeNode(Integer.parseInt(rightValue));
                queue.offer(parent.right);
            }
        }

        return root;
    }

}
