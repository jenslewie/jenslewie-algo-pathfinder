package org.example.leetcode.global;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0378Test {

    private LeetCode0378 leetCode;

    @BeforeEach
    public void init(){
        leetCode = new LeetCode0378();
    }

    @Test
    void test1() {
        int[][] data = new int[][]{{1, 5, 9},{10, 11, 13},{10 , 12, 15}};
        assertEquals(13, leetCode.kthSmallest(data, 8));
    }

    @Test
    void test2() {
        int[][] data = new int[][]{{-5}};
        assertEquals(-5, leetCode.kthSmallest(data, 1));
    }
}
