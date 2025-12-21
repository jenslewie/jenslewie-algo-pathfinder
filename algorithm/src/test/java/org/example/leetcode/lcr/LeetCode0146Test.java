package org.example.leetcode.lcr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LeetCode0146Test {

    private LeetCode0146 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0146();
    }

    @Test
    void test1() {
        assertArrayEquals(new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5},
                leetCode.spiralArray(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    @Test
    void test2() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16},
                leetCode.spiralArray(new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}}));
    }
}
