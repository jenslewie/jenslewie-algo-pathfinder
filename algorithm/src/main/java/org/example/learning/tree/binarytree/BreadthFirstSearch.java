package org.example.learning.tree.binarytree;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;
import org.example.model.tree.TreeNodeState;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeBuilder.buildTree(new Integer[] {1, 2, 3, null, 5, 6}, 0);
        BreadthFirstSearch bfs = new BreadthFirstSearch();

        System.out.print("Level-order Traversal : ");
        bfs.levelOrderTraversal(root);
        System.out.println();

        System.out.println("Level-order Traversal with depth : ");
        bfs.levelOrderTraversalWithDepth(root);

        System.out.println("Level-order Traversal with weight : ");
        bfs.levelOrderTraversalWithWeight(root);
    }

    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public void levelOrderTraversalWithDepth(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.println("Depth: " + depth + " value: " + node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
    }

    public void levelOrderTraversalWithWeight(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNodeState> queue = new LinkedList<>();
        queue.offer(new TreeNodeState(root, 1));

        while (!queue.isEmpty()) {
            TreeNodeState treeNodeState = queue.poll();
            System.out.println("Weight: " + treeNodeState.depth + " value: " + treeNodeState.node.val);

            if (treeNodeState.node.left != null) {
                queue.offer(new TreeNodeState(treeNodeState.node.left, treeNodeState.depth + 1));
            }

            if (treeNodeState.node.right != null) {
                queue.offer(new TreeNodeState(treeNodeState.node.right, treeNodeState.depth + 1));
            }
        }
    }
}
