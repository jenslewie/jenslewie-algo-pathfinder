package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.com/problems/count-complete-tree-nodes">LeetCode 222: Count Complete Tree Nodes</a>
 * <p>
 * Given the root of a complete binary tree, return the number of the nodes in the tree. <br>
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all
 * nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h. <br>
 * Design an algorithm that runs in less than O(n) time complexity.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: BFS level-order traversal. <br>
 * - Traverse nodes using a queue and count each node when it is dequeued. <br>
 * - Enqueue left and right children when they exist.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Queue holds up to one level of nodes.
 */
public class LeetCode0222_1 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.offerLast(node.left);
                    ans++;
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                    ans++;
                }
            }
        }
        return ans;
    }

}
