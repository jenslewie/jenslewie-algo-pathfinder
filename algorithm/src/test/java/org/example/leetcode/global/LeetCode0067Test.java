package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0067Test {

    private LeetCode0067 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0067();
    }

    @Test
    void test1() {
        assertEquals("100", leetCode.addBinary("11", "1"));
    }

    @Test
    void test2() {
        assertEquals("10101", leetCode.addBinary("1010", "1011"));
    }
}
