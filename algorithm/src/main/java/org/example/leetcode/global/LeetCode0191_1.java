package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/number-of-1-bits">LeetCode 191: Number of 1 Bits</a>
 * <p>
 * Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Iterative bit check with unsigned shift. <br>
 * - Add the least-significant bit (`n & 1`) to the running count each step. <br>
 * - Use unsigned right shift to progress until all bits are processed.
 * <p>
 * Time Complexity: O(32) <br>
 * - Processes at most 32 bits for an `int`.
 * <p>
 * Space Complexity: O(1) <br>
 * - Uses constant extra variables.
 */
public class LeetCode0191_1 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }

}
