package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0027Test {

    private LeetCode0027 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0027();
    }

    @Test
    void test1() {
        assertEquals(2, leetCode.removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    @Test
    void test2() {
        assertEquals(5, leetCode.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
