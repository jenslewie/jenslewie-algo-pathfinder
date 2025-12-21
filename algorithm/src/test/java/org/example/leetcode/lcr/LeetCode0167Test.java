package org.example.leetcode.lcr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0167Test {

    private LeetCode0167 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0167();
    }

    @Test
    void test1() {
        assertEquals(6, leetCode.dismantlingAction("dbascDdad"));
    }

    @Test
    void test2() {
        assertEquals(1, leetCode.dismantlingAction("KKK"));
    }

    @Test
    void test3() {
        assertEquals(3, leetCode.dismantlingAction("pwwkew"));
    }
}
