package org.example.leetcode.lcr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeetCode0057Test {

    private LeetCode0057 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0057();
    }

    @Test
    void test1() {
        assertTrue(leetCode.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
    }

    @Test
    void test2() {
        assertTrue(leetCode.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
    }
}
