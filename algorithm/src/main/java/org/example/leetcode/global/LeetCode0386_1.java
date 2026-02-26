package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/lexicographical-numbers">LeetCode 386: Lexicographical Numbers</a>
 * <p>
 * Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order. <br>
 * You must write an algorithm that runs in O(n) time and uses O(1) extra space.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: DFS preorder traversal over implicit 10-ary prefix tree. <br>
 * - Treat each integer as a node in lexical prefix tree and expand children by appending digits. <br>
 * - Traverse from roots 1..9 in preorder to generate lexical order.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: each value from 1..n is emitted once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: recursion depth by digit length of n.
 */
public class LeetCode0386_1 {

    private List<Integer> ans;

    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            traverse(i, n);
        }
        return ans;
    }

    private void traverse(int root, int n) {
        if (root > n) {
            return;
        }
        ans.add(root);
        for (int child = root * 10; child < root * 10 + 10; child++) {
            traverse(child, n);
        }
    }

}
