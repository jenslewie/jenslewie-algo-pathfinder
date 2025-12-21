package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeetCode0220Test {

    private LeetCode0220 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0220();
    }

    @Test
    void test1() {
        int[] nums = {1, 2, 3, 1};
        int indexDiff = 3, valueDiff = 0;
        assertTrue(leetCode.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
        assertTrue(leetCode.containsNearbyAlmostDuplicate2(nums, indexDiff, valueDiff));
    }

    @Test
    void test2() {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int indexDiff = 2, valueDiff = 3;
        assertFalse(leetCode.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
        assertFalse(leetCode.containsNearbyAlmostDuplicate2(nums, indexDiff, valueDiff));
    }
}
