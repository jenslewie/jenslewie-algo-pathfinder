package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0438Test {

    private LeetCode0438 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0438();
    }

    @Test
    void test1() {
        assertEquals(List.of(0, 6), leetCode.findAnagrams("cbaebabacd", "abc"));
    }

    @Test
    void test2() {
        assertEquals(List.of(0, 1, 2), leetCode.findAnagrams("abab", "ab"));
    }
}
