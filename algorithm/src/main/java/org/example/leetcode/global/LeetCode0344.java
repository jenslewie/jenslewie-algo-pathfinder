package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/reverse-string">LeetCode 344: Reverse String</a>
 * <p>
 * Approach: Two pointers. <br>
 * - Swap characters from both ends moving inward. <br>
 * - Stop when pointers cross.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is swapped once.
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place swaps only.
 */
public class LeetCode0344 {

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
