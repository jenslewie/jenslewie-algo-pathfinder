package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LeetCode0167Test {

    private LeetCode0167 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0167();
    }

    @Test
    void test1() {
        assertArrayEquals(new int[]{1, 2}, leetCode.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void test2() {
        assertArrayEquals(new int[]{1, 3}, leetCode.twoSum(new int[]{2, 3, 4}, 6));
    }

    @Test
    void test3() {
        assertArrayEquals(new int[]{1, 2}, leetCode.twoSum(new int[]{-1, 0}, -1));
    }
}
