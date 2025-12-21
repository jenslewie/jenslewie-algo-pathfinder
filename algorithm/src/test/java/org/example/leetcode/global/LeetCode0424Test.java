package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0424Test {

    private LeetCode0424 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0424();
    }

    @Test
    void test1() {
        assertEquals(4, leetCode.characterReplacement("ABAB", 2));
    }

    @Test
    void test2() {
        assertEquals(4, leetCode.characterReplacement("AABABBA", 1));
    }
}
