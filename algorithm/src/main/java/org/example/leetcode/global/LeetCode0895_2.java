package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/maximum-frequency-stack">LeetCode 895: Maximum Frequency Stack</a>
 * <p>
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack. <br>
 * Implement the FreqStack class:
 * <p>
 * Difficulty: Hard
 * <p>
 * Approach: Map of frequency to stacks. <br>
 - Track value frequencies and per-frequency stacks. <br>
 - Pop from the stack at max frequency.
 * <p>
 * Time Complexity: O(1) <br>
 * - Push and pop are constant time.
 * <p>
 * Space Complexity: O(n) <br>
 * - Store all pushed values.
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

    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        maxFreq = Math.max(maxFreq, freq);
        valToFreq.put(val, freq);
        freqToValsMap.computeIfAbsent(freq, k -> new Stack<>()).add(val);
    }

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