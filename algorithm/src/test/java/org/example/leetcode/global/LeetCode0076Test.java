package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0076Test {

    private LeetCode0076 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0076();
    }

    @Test
    void test1() {
        assertEquals("BANC", leetCode.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    void test2() {
        assertEquals("a", leetCode.minWindow("a", "a"));
    }

    @Test
    void test3() {
        assertEquals("", leetCode.minWindow("a", "aa"));
    }
}
