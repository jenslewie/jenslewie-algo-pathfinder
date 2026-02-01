package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Frequency stack implementation using maps for frequency tracking
 */
public class LeetCode0895_2 {

    int maxFreq;
    Map<Integer, Integer> valToFreq;
    Map<Integer, Stack<Integer>> freqToValsMap;

    public LeetCode0895_2() {
        maxFreq = 0;
        valToFreq = new HashMap<>();
        freqToValsMap = new HashMap<>();
    }

    /**
     * Push element to the frequency stack using map-based approach
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
        freqToValsMap.computeIfAbsent(freq, k -> new Stack<>()).add(val);
    }

    /**
     * Pop element from the frequency stack using map-based approach
     * Time Complexity: O(1)
     * - Removing from the stack takes constant time
     * <p>
     * Space Complexity: O(1)
     * - No additional space needed
     */
    public int pop() {
        int value = freqToValsMap.get(maxFreq).pop();
        if (freqToValsMap.get(maxFreq).isEmpty()) {
            freqToValsMap.remove(maxFreq);
            maxFreq--;
        }
        valToFreq.put(value, valToFreq.get(value) - 1);
        return value;
    }
}