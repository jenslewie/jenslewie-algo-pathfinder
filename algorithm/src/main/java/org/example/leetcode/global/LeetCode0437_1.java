package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/path-sum-iii">LeetCode 437: Path Sum III</a>
 * <p>
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum. <br>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: DFS traversal with running sums per path end. <br>
 * - Maintain a list of sums for all downward paths ending at current node. <br>
 * - Update each sum with current value, add single-node path, and count matches.
 * <p>
 * Time Complexity: O(n * h) <br>
 * - n: number of nodes, h: height (list update per node can be up to path length).
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion stack plus running path-sum list.
 */
public class LeetCode0437_1 {

    private int ans;
    private int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        ans = 0;
        this.targetSum = targetSum;
        var list = new ArrayList<Long>();
        traverse(root, list);
        return ans;
    }

    private void traverse(TreeNode node, ArrayList<Long> list) {
        if (node == null) {
            return;
        }
        list.replaceAll(i -> i + node.val);
        list.add((long) node.val);
        ans += list.stream().filter(i -> i == targetSum).toList().size();
        traverse(node.left, list);
        traverse(node.right, list);
        list.remove(list.size() - 1);
        list.replaceAll(i -> i - node.val);
    }

}
