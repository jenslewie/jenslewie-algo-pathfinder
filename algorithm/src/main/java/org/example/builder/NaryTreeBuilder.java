package org.example.builder;

import org.example.model.tree.NaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class NaryTreeBuilder {

    /**
     * Use level order to build N-ary tree
     * Use null to separate collections belong to different parent node in the same level
     * @param arr
     * @return
     */
    public static NaryTreeNode buildNaryTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        NaryTreeNode root = new NaryTreeNode(arr[0]);
        Queue<NaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (index < arr.length && !queue.isEmpty()) {
            NaryTreeNode node = queue.poll();

            while (index < arr.length && arr[index] != null) {
                NaryTreeNode newNode = new NaryTreeNode(arr[index++]);
                node.children.add(newNode);
                queue.offer(newNode);
            }

            index++;
        }

        return root;
    }

}
