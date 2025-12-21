package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LeetCode0059Test {

    private LeetCode0059 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0059();
    }

    @Test
    void test1() {
        assertArrayEquals(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, leetCode.generateMatrix(3));
    }

    @Test
    void test2() {
        assertArrayEquals(new int[][]{{1}}, leetCode.generateMatrix(1));
    }

    @Test
    void test3() {
        assertArrayEquals(new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}}, leetCode.generateMatrix(4));
    }
}
