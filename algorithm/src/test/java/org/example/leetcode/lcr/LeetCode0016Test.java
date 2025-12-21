package org.example.leetcode.lcr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0016Test {

    private LeetCode0016 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0016();
    }

    @Test
    void test1() {
        String s = "abcabcbb";
        assertEquals(3, leetCode.lengthOfLongestSubstring(s));
        assertEquals(3, leetCode.lengthOfLongestSubstring2(s));
    }

    @Test
    void test2() {
        String s = "bbbbb";
        assertEquals(1, leetCode.lengthOfLongestSubstring(s));
        assertEquals(1, leetCode.lengthOfLongestSubstring2(s));
    }

    @Test
    void test3() {
        String s = "pwwkew";
        assertEquals(3, leetCode.lengthOfLongestSubstring(s));
        assertEquals(3, leetCode.lengthOfLongestSubstring2(s));
    }

    @Test
    void test4() {
        String s = "";
        assertEquals(0, leetCode.lengthOfLongestSubstring(s));
        assertEquals(0, leetCode.lengthOfLongestSubstring2(s));
    }

    @Test
    void test5() {
        String s = "abba";
        assertEquals(2, leetCode.lengthOfLongestSubstring(s));
        assertEquals(2, leetCode.lengthOfLongestSubstring2(s));
    }
}
