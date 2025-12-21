package org.example.builder;

import org.example.model.tree.TreeNode;

public class BinaryTreeBuilder {

    public static TreeNode buildTree(Integer[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }

        if (arr[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(arr[index]);
        node.left = buildTree(arr, 2 * index + 1);
        node.right = buildTree(arr, 2 * index + 2);

        return node;
    }

}
