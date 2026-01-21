package org.example.learning.tree.binarytree;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;

public class DepthFirstSearch {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeBuilder.buildTree(new Integer[] {1, 2, 3, null, 5, 6}, 0);
        DepthFirstSearch dfs = new DepthFirstSearch();

        System.out.print("Preorder Traversal : ");
        dfs.PreOrderTraversal(root);
        System.out.println();

        System.out.print("Inorder Traversal : ");
        dfs.InOrderTraversal(root);
        System.out.println();

        System.out.print("Postorder Traversal : ");
        dfs.PostOrderTraversal(root);
        System.out.println();
    }

    public void PreOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }

    public void InOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        InOrderTraversal(root.left);
        System.out.print(root.val + " ");
        InOrderTraversal(root.right);
    }

    public void PostOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }
}
