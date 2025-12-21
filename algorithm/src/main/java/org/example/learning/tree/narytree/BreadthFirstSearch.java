package org.example.learning.tree.narytree;

import org.example.builder.NaryTreeBuilder;
import org.example.model.tree.NaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        NaryTreeNode root = NaryTreeBuilder.buildNaryTree(new Integer[] {1, 2, 3, 4, null, 5, null, 6, null, 7, null});
        BreadthFirstSearch bfs = new BreadthFirstSearch();

        bfs.LevelOrderTraversal(root);
        System.out.println();

        System.out.println("Level-order Traversal with depth : ");
        bfs.LevelOrderTraversalWithDepth(root);
    }

    public void LevelOrderTraversal(NaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<NaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            NaryTreeNode node = queue.poll();
            System.out.print(node.value + " ");
            for (NaryTreeNode child : node.children) {
                queue.offer(child);
            }
        }
    }

    public void LevelOrderTraversalWithDepth(NaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<NaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NaryTreeNode node = queue.poll();
                System.out.println("Depth: " + depth + " value: " + node.value);
                for (NaryTreeNode child : node.children) {
                    queue.offer(child);
                }
            }
            depth++;
        }
    }

}
