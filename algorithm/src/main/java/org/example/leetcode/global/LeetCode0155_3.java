package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/min-stack">...</a>
 * Approach 3: Stack with map for counting occurrences
 */
public class LeetCode0155_3 implements MinStack {

    private final Stack<Integer> stack;
    private final Map<Integer, Integer> map;

    public LeetCode0155_3() {
        this.stack = new Stack<>();
        this.map = new HashMap<>();
    }

    /**
     * Time Complexity: O(1)
     * - Push operation takes constant time
     * <p>
     * Space Complexity: O(1) for the operation itself
     * - But overall space is O(n) where n is the number of elements pushed
     */
    @Override
    public void push(int val) {
        stack.push(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    /**
     * Time Complexity: O(1) for pop from stack, O(n) to find min
     * - Overall: O(n) where n is the number of unique values
     * <p>
     * Space Complexity: O(1)
     */
    @Override
    public void pop() {
        if (!stack.isEmpty()) {
            int val = stack.pop();
            map.put(val, map.get(val) - 1);
            if (map.get(val) == 0) {
                map.remove(val);
            }
        }
    }

    /**
     * Time Complexity: O(1)
     * - Peek operation takes constant time
     * <p>
     * Space Complexity: O(1)
     */
    @Override
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        throw new RuntimeException("Stack is empty");
    }

    /**
     * Time Complexity: O(n)
     * - Where n is the number of unique values in the map
     * <p>
     * Space Complexity: O(1)
     */
    @Override
    public int getMin() {
        if (!map.isEmpty()) {
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 0) {
                    min = Math.min(min, entry.getKey());
                }
            }
            return min;
        }
        throw new RuntimeException("Stack is empty");
    }
}