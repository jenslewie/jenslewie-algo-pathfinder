package org.example.leetcode.lcr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0009Test {

    private LeetCode0009 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0009();
    }

    @Test
    void test1() {
        assertEquals(8, leetCode.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    @Test
    void test2() {
        assertEquals(0, leetCode.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }
}
