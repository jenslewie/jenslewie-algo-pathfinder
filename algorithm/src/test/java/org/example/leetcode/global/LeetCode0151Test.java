package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0151Test {

    private LeetCode0151 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0151();
    }

    @Test
    void test1() {
        assertEquals("blue is sky the", leetCode.reverseWords("the sky is blue"));
        assertEquals("blue is sky the", leetCode.reverseWords2("the sky is blue"));
    }

    @Test
    void test2() {
        assertEquals("world hello", leetCode.reverseWords("  hello world  "));
        assertEquals("world hello", leetCode.reverseWords2("  hello world  "));
    }

    @Test
    void test3() {
        assertEquals("example good a", leetCode.reverseWords("a good   example"));
        assertEquals("example good a", leetCode.reverseWords2("a good   example"));
    }
}
