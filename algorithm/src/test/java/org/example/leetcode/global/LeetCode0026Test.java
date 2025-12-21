package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0026Test {

    private LeetCode0026 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0026();
    }

    @Test
    void test1() {
        assertEquals(2, leetCode.removeDuplicates(new int[]{1, 1, 2}));
    }

    @Test
    void test2() {
        assertEquals(5, leetCode.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
