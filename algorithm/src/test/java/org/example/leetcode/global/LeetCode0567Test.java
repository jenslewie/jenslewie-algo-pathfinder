package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeetCode0567Test {

    private LeetCode0567 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0567();
    }

    @Test
    void test1() {
        assertTrue(leetCode.checkInclusion("ab", "eidbaooo"));
    }

    @Test
    void test2() {
        assertFalse(leetCode.checkInclusion("ab", "eidboaoo"));
    }

    @Test
    void test3() {
        assertTrue(leetCode.checkInclusion("abcdxioe", "abcdioxe"));
    }
}
