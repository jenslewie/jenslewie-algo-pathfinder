package org.example.leetcode.lcr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0015Test {

    private LeetCode0015 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0015();
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
