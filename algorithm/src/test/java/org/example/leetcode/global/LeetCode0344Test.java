package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LeetCode0344Test {

    private LeetCode0344 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0344();
    }

    @Test
    void test1() {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        leetCode.reverseString(s);
        assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, s);
    }

    @Test
    void test2() {
        char[] s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        leetCode.reverseString(s);
        assertArrayEquals(new char[]{'h', 'a', 'n', 'n', 'a', 'H'}, s);
    }
}
