package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-paths">LeetCode 257: Binary Tree Paths</a>
 * <p>
 * Given the root of a binary tree, return all root-to-leaf paths in any order. <br>
 * A leaf is a node with no children.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Iterative BFS with queue. <br>
 * - Enqueue node and path segments list. <br>
 * - When reaching a leaf, join the path segments to build the answer.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is processed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Queue stores nodes and paths; output paths also take space.
 */
public class LeetCode0257_1 {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        var ans = new ArrayList<String>();
        var queueNode = new ArrayDeque<TreeNode>();
        var pathNode = new ArrayDeque<List<String>>();
        queueNode.offerLast(root);
        pathNode.offerLast(new ArrayList<>(List.of(String.valueOf(root.val))));
        while (!queueNode.isEmpty()) {
            var node = queueNode.pollFirst();
            var path = pathNode.pollFirst();
            if (node.left == null && node.right == null) {
                ans.add(String.join("->", path));
            } else {
                if (node.left != null) {
                    queueNode.offerLast(node.left);
                    var newPath = new ArrayList<>(path);
                    newPath.add(String.valueOf(node.left.val));
                    pathNode.offerLast(newPath);
                }
                if (node.right != null) {
                    queueNode.offerLast(node.right);
                    var newPath = new ArrayList<>(path);
                    newPath.add(String.valueOf(node.right.val));
                    pathNode.offerLast(newPath);
                }
            }
        }

        return ans;
    }

}
