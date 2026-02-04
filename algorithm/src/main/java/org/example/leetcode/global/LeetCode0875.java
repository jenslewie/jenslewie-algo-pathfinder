package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/koko-eating-bananas">LeetCode 875: Koko Eating Bananas</a>
 * <p>
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours. <br>
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour. <br>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return. <br>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Binary search on eating speed. <br>
 - Check if a speed finishes within h hours. <br>
 - Shrink the search range accordingly.
 * <p>
 * Time Complexity: O(n * log(M)) <br>
 * - n: piles count; M: max pile size.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
 */
public class LeetCode0875 {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left <= right) {
            int speed = left + (right - left) / 2;
            if (h >= getTime(piles, speed)) {
                right = speed - 1;
            } else {
                left = speed + 1;
            }
        }
        return left;
    }

    private long getTime(int[] piles, int speed) {
        long hours = 0;
        for(int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }

}
