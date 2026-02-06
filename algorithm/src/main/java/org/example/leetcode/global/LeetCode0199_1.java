package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">LeetCode 199: Binary Tree Right Side View</a>
 * <p>
 * Given the root of a binary tree, imagine yourself standing on the right side of it,<br>
 * return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: BFS with level-order traversal. <br>
 * - Use queue to process nodes level by level. <br>
 * - For each level, record the last node's value.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; visit each node once.
 * <p>
 * Space Complexity: O(w) <br>
 * - w: maximum width of the tree; queue storage.
 */
public class LeetCode0199_1 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        var ans = new ArrayList<Integer>();
        var queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.pollFirst();
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
                if (i == size - 1) {
                    ans.add(node.val);
                }
            }
        }

        return ans;
    }

}
