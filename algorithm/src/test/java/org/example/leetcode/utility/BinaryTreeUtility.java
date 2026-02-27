package org.example.leetcode.utility;

import org.example.model.tree.TreeNode;

import java.util.Objects;

public class BinaryTreeUtility {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSameNextStructure(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        Integer aNextVal = (a.next != null) ? a.next.val : null;
        Integer bNextVal = (b.next != null) ? b.next.val : null;

        return a.val == b.val &&
                Objects.equals(aNextVal, bNextVal) &&
                isSameNextStructure(a.left, b.left) &&
                isSameNextStructure(a.right, b.right);
    }

    public static TreeNode findNodeByValue(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode left = findNodeByValue(root.left, val);
        return left != null ? left : findNodeByValue(root.right, val);
    }

    public static String serializeTree(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        var queue = new java.util.LinkedList<TreeNode>();
        queue.offer(root);

        // Flag to track if we should continue processing
        boolean hasNonNull = true;

        while (!queue.isEmpty() && hasNonNull) {
            hasNonNull = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                if (node == null) {
                    sb.append("null").append(",");
                } else {
                    sb.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                    // If we added any non-null nodes, we should continue
                    if (node.left != null || node.right != null) {
                        hasNonNull = true;
                    }
                }
            }
        }

        // Remove trailing comma
        if (!sb.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }

}
