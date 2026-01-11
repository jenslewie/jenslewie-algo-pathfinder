package org.example.learning.stack;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 4, 3};
        System.out.println(Arrays.toString(MonotonicStack.calculateGreaterElementsFromRight(nums)));
        System.out.println(Arrays.toString(MonotonicStack.calculateGreaterElementsFromLeft(nums)));
    }

    public static int[] calculateGreaterElementsFromRight(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }

    public static int[] calculateGreaterElementsFromLeft(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return ans;
    }

}
