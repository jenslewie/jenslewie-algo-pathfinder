package org.example.leetcode.lcr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeetCode0014Test {

    private LeetCode0014 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0014();
    }

    @Test
    void test1() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        assertTrue(leetCode.checkInclusion1(s1, s2));
        assertTrue(leetCode.checkInclusion2(s1, s2));
        assertTrue(leetCode.checkInclusion3(s1, s2));
        assertTrue(leetCode.checkInclusion4(s1, s2));
    }

    @Test
    void test2() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        assertFalse(leetCode.checkInclusion1(s1, s2));
        assertFalse(leetCode.checkInclusion2(s1, s2));
        assertFalse(leetCode.checkInclusion3(s1, s2));
        assertFalse(leetCode.checkInclusion4(s1, s2));
    }
}
