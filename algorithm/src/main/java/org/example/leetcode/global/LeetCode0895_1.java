package org.example.leetcode.global;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/maximum-frequency-stack">LeetCode 895: Maximum Frequency Stack</a>
 * <p>
 * Approach: Array of stacks by frequency. <br>
 - Track value frequencies and group values by frequency. <br>
 - Pop from the highest-frequency list.
 * <p>
 * Time Complexity: O(1) <br>
 * - Push and pop are constant time.
 * <p>
 * Space Complexity: O(n) <br>
 * - Store all pushed values.
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

    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        maxFreq = Math.max(maxFreq, freq);
        valToFreq.put(val, freq);
        if (freqToValsArray[freq] == null) {
            freqToValsArray[freq] = new LinkedList<>();
        }
        freqToValsArray[freq].add(val);
    }

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