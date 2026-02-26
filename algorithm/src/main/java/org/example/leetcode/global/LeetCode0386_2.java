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
 * Approach: Iterative lexical successor simulation. <br>
 * - Maintain current value and move to next lexical number using multiply/divide adjustments. <br>
 * - Prefer descending to child (x10), otherwise backtrack until next sibling is valid.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: exactly n numbers are generated.
 * <p>
 * Space Complexity: O(1) <br>
 * - Extra state is constant besides output list.
 */
public class LeetCode0386_2 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0, j = 1; i < n; i++) {
            ans.add(j);
            if (j * 10 <= n) {
                j *= 10;
            } else {
                while (j + 1 > n || j % 10 == 9) {
                    j /= 10;
                }
                j++;
            }
        }

        return ans;
    }

}
