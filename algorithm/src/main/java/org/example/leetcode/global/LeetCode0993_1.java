package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/cousins-in-binary-tree">LeetCode 993: Cousins in Binary Tree</a>
 * <p>
 * Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise. <br>
 * Two nodes of a binary tree are cousins if they have the same depth with different parents. <br>
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: BFS level-order traversal with parent tracking. <br>
 * - Scan one level at a time and record parent nodes for x and y when found. <br>
 * - They are cousins only if both found in same level with different parents.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes visited in BFS.
 * <p>
 * Space Complexity: O(w) <br>
 * - w: maximum width of the tree (queue size).
 */
public class LeetCode0993_1 {

    public boolean isCousins(TreeNode root, int x, int y) {
        var queue = new ArrayDeque<TreeNode>();
        var parentList = new ArrayList<TreeNode>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            if (parentList.size() == 1) {
                return false;
            }
            if (parentList.size() == 2) {
                return parentList.get(0) != parentList.get(1);
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                processNode(node.left, x, y, node, queue, parentList);
                processNode(node.right, x, y, node, queue, parentList);
            }
        }
        return false;
    }

    private void processNode(TreeNode node, int x, int y, TreeNode parentNode, ArrayDeque<TreeNode> queue, ArrayList<TreeNode> parentList) {
        if (node != null) {
            queue.offerLast(node);
            if (node.val == x || node.val == y) {
                parentList.add(parentNode);
            }
        }
    }

}
