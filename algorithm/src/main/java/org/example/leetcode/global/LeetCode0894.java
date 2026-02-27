package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/all-possible-full-binary-trees">LeetCode 894: All Possible Full Binary Trees</a>
 * <p>
 * Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0. <br>
 * Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order. <br>
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Divide-and-conquer recursion over odd subtree sizes. <br>
 * - Full binary tree requires odd node count; split n - 1 nodes into odd-sized left/right parts. <br>
 * - Recursively enumerate left and right subtree candidates, then combine each pair under new root.
 * <p>
 * Time Complexity: O(2^n) <br>
 * - Enumerates all valid full binary tree structures recursively.
 * <p>
 * Space Complexity: O(2^n) <br>
 * - Stores generated trees plus recursion stack.
 */
public class LeetCode0894 {

    public List<TreeNode> allPossibleFBT(int n) {
        var fullBinaryTrees = new ArrayList<TreeNode>();
        if (n % 2 == 0) {
            return fullBinaryTrees;
        }
        if (n == 1) {
            fullBinaryTrees.add(new TreeNode(0));
            return fullBinaryTrees;
        }
        
        for (int i = 1; i < n; i += 2) {
            var leftSubtrees = allPossibleFBT(i);
            var rightSubtrees = allPossibleFBT(n - 1 - i);
            
            for (var leftSubtree : leftSubtrees) {
                for (var rightSubtree : rightSubtrees) {
                    fullBinaryTrees.add(new TreeNode(0, leftSubtree, rightSubtree));
                }
            }
        }
        return fullBinaryTrees;
    }

}
