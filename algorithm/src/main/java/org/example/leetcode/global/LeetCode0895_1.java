package org.example.leetcode.global;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Frequency stack implementation using arrays for frequency tracking
 */
public class LeetCode0895_1 {

    int maxFreq;
    Map<Integer, Integer> valToFreq;
    LinkedList<Integer>[] freqToValsArray;

    public LeetCode0895_1() {
        maxFreq = 0;
        valToFreq = new HashMap<>();
        freqToValsArray = new LinkedList[2 * (int) 1e4];
    }

    /**
     * Push element to the frequency stack using array-based approach
     * Time Complexity: O(1)
     * - Adding to the stack takes constant time
     * <p>
     * Space Complexity: O(N)
     * - Where N is the total number of pushes
     */
    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        maxFreq = Math.max(maxFreq, freq);
        valToFreq.put(val, freq);
        if (freqToValsArray[freq] == null) {
            freqToValsArray[freq] = new LinkedList<>();
        }
        freqToValsArray[freq].add(val);
    }

    /**
     * Pop element from the frequency stack using array-based approach
     * Time Complexity: O(1)
     * - Removing from the stack takes constant time
     * <p>
     * Space Complexity: O(1)
     * - No additional space needed
     */
    public int pop() {
        LinkedList<Integer> list = freqToValsArray[maxFreq];
        int value = list.removeLast();
        if (list.isEmpty()) {
            maxFreq--;
        }
        valToFreq.put(value, valToFreq.get(value) - 1);
        return value;
    }
}