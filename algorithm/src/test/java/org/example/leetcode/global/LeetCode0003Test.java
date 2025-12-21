package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0003Test {

    private LeetCode0003 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0003();
    }

    @Test
    void test1() {
        String str = "abcabcbb";
        int expected = 3;
        assertEquals(expected, leetCode.lengthOfLongestSubstring(str));
        assertEquals(expected, leetCode.lengthOfLongestSubstring2(str));
        assertEquals(expected, leetCode.lengthOfLongestSubstring3(str));
    }

    @Test
    void test2() {
        String str = "bbbbb";
        int expected = 1;
        assertEquals(expected, leetCode.lengthOfLongestSubstring(str));
        assertEquals(expected, leetCode.lengthOfLongestSubstring2(str));
        assertEquals(expected, leetCode.lengthOfLongestSubstring3(str));
    }

    @Test
    void test3() {
        String str = "pwwkew";
        int expected = 3;
        assertEquals(expected, leetCode.lengthOfLongestSubstring(str));
        assertEquals(expected, leetCode.lengthOfLongestSubstring2(str));
        assertEquals(expected, leetCode.lengthOfLongestSubstring3(str));
    }

    @Test
    void test4() {
        String str = " ";
        int expected = 1;
        assertEquals(expected, leetCode.lengthOfLongestSubstring(str));
        assertEquals(expected, leetCode.lengthOfLongestSubstring2(str));
        assertEquals(expected, leetCode.lengthOfLongestSubstring3(str));
    }

    @Test
    void test5() {
        String str = "dfdv";
        int expected = 3;
        assertEquals(expected, leetCode.lengthOfLongestSubstring(str));
        assertEquals(expected, leetCode.lengthOfLongestSubstring2(str));
        assertEquals(expected, leetCode.lengthOfLongestSubstring3(str));
    }
}
