package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LeetCode0283Test {

    private LeetCode0283 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0283();
    }

    @Test
    void test1() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        leetCode.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    void test2() {
        int[] nums = new int[]{0};
        leetCode.moveZeroes(nums);
        assertArrayEquals(new int[]{0}, nums);
    }
}
