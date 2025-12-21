package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode1004Test {

    private LeetCode1004 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode1004();
    }

    @Test
    void test1() {
        assertEquals(6, leetCode.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        assertEquals(6, leetCode.longestOnes2(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    @Test
    void test2() {
        assertEquals(10, leetCode.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        assertEquals(10, leetCode.longestOnes2(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    @Test
    void test3() {
        assertEquals(4, leetCode.longestOnes(new int[]{0, 0, 0, 1}, 4));
        assertEquals(4, leetCode.longestOnes2(new int[]{0, 0, 0, 1}, 4));
    }
}
