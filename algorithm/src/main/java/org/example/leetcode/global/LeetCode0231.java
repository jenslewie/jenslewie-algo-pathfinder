package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/power-of-two">LeetCode 231: Power of Two</a>
 * <p>
 * Given an integer n, return true if it is a power of two. Otherwise, return false. <br>
 * An integer n is a power of two, if there exists an integer x such that n == 2^x.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Bit manipulation trick. <br>
 * - A power of two has exactly one bit set in binary representation. <br>
 * - For n > 0, n & (n-1) removes the lowest set bit. <br>
 * - If result is 0, then n had only one bit set.
 * <p>
 * Time Complexity: O(1) <br>
 * - Constant time bit operations.
 * <p>
 * Space Complexity: O(1) <br>
 * - No extra space used.
 */
public class LeetCode0231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
