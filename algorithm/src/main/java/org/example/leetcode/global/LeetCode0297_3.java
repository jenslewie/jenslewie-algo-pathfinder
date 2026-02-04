package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree">LeetCode 297: Serialize and Deserialize Binary Tree</a>
 * <p>
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment. <br>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure. <br>
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Difficulty: Hard
 * <p>
 * Approach: Level-order BFS serialization. <br>
 * - Serialize by visiting nodes level by level with null markers. <br>
 * - Deserialize using a queue to rebuild children in order.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is processed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Queue and serialized representation store all nodes.
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
        if (data == null || data.isEmpty()) {
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
