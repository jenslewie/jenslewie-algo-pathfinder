package org.example.leetcode.lcr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0008Test {

    private LeetCode0008 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0008();
    }

    @Test
    void test1() {
        assertEquals(2, leetCode.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    @Test
    void test2() {
        assertEquals(1, leetCode.minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    @Test
    void test3() {
        assertEquals(0, leetCode.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
