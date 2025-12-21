package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode1658Test {

    private LeetCode1658 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode1658();
    }

    @Test
    void test1() {
        assertEquals(2, leetCode.minOperations(new int[] {1, 1, 4, 2, 3}, 5));
    }
}
