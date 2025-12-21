package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0005Test {

    private LeetCode0005 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0005();
    }

    @Test
    void test1() {
        assertEquals("aba", leetCode.longestPalindrome("babad"));
    }

    @Test
    void test2() {
        assertEquals("bb", leetCode.longestPalindrome("cbbd"));
    }

    @Test
    void test3() {
        assertEquals("a", leetCode.longestPalindrome("a"));
    }
}
