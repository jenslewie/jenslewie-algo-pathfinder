package org.example.leetcode.lcr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0061Test {

    private LeetCode0061 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0061();
    }

    @Test
    void test1() {
        assertEquals(List.of(List.of(1, 2), List.of(1, 4), List.of(1, 6)), leetCode.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }

    @Test
    void test2() {
        assertEquals(List.of(List.of(1, 1), List.of(1, 1)), leetCode.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
    }

    @Test
    void test3() {
        assertEquals(List.of(List.of(1, 3), List.of(2, 3)), leetCode.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
    }
}
