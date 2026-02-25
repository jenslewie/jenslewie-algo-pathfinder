package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/path-sum-iii">LeetCode 437: Path Sum III</a>
 * <p>
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum. <br>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: DFS with prefix-sum frequency map. <br>
 * - Track current root-to-node prefix sum during traversal. <br>
 * - Number of valid paths ending at current node is count(prefixSum - target) seen on current path.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of visited nodes.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth and prefix map entries along the active path.
 */
public class LeetCode0437_2 {
    private int ans;
    private int targetSum;
    private long sum;
    private Map<Long, Integer> map;

    public int pathSum(TreeNode root, int targetSum) {
        ans = 0;
        sum = 0;
        this.targetSum = targetSum;
        this.map = new HashMap<>();
        map.put(0L, 1);
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        sum += node.val;
        ans += map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        traverse(node.left);
        traverse(node.right);

        map.put(sum, map.get(sum) - 1);
        sum -= node.val;
    }

}
