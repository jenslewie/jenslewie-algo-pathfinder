package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0713Test {

    private LeetCode0713 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0713();
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
