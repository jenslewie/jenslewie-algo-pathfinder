package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeetCode0219Test {

    private LeetCode0219 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0219();
    }

    @Test
    void test1() {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        assertTrue(leetCode.containsNearbyDuplicate(nums, k));
        assertTrue(leetCode.containsNearbyDuplicate2(nums, k));
        assertTrue(leetCode.containsNearbyDuplicate3(nums, k));
    }

    @Test
    void test2() {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        assertTrue(leetCode.containsNearbyDuplicate(nums, k));
        assertTrue(leetCode.containsNearbyDuplicate2(nums, k));
        assertTrue(leetCode.containsNearbyDuplicate3(nums, k));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        assertFalse(leetCode.containsNearbyDuplicate(nums, k));
        assertFalse(leetCode.containsNearbyDuplicate2(nums, k));
        assertFalse(leetCode.containsNearbyDuplicate3(nums, k));
    }
}
