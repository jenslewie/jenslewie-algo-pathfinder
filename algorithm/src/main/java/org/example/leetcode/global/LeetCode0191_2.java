package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/number-of-1-bits">LeetCode 191: Number of 1 Bits</a>
 * <p>
 * Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Brian Kernighan bit trick. <br>
 * - Repeatedly clear the lowest set bit using `n & (n - 1)`. <br>
 * - Count how many times bits are cleared until `n` becomes zero.
 * <p>
 * Time Complexity: O(k) <br>
 * - k: number of set bits in `n` (worst case 32).
 * <p>
 * Space Complexity: O(1) <br>
 * - Uses constant extra variables.
 */
public class LeetCode0191_2 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
