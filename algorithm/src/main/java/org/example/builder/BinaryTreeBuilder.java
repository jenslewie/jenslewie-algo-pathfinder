package org.example.builder;

import org.example.model.tree.TreeNode;

public class BinaryTreeBuilder {

    public static TreeNode build(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }
        return buildTree(arr, 0);
    }

    public static TreeNode buildTree(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(arr[index]);
        node.left = buildTree(arr, 2 * index + 1);
        node.right = buildTree(arr, 2 * index + 2);

        return node;
    }

}
