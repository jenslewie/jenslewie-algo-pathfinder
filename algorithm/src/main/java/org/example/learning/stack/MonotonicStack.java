package org.example.learning.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class MonotonicStack {

    public enum Direction {
        NEXT,
        PREVIOUS
    }

    public enum Mode {
        GREATER_STRICT,
        GREATER_OR_EQUAL,
        SMALLER_STRICT,
        SMALLER_OR_EQUAL
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{2, 1, 2, 4, 3, 3};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(MonotonicStack.nextGreaterElementsFromRight(nums)));
        System.out.println(Arrays.toString(MonotonicStack.nextGreaterElementsFromLeft(nums)));

        System.out.println(Arrays.toString(getElementsFromRight(nums, Direction.NEXT, Mode.GREATER_STRICT)));
        System.out.println(Arrays.toString(getElementsFromRight(nums, Direction.NEXT, Mode.GREATER_OR_EQUAL)));
        System.out.println(Arrays.toString(getElementsFromRight(nums, Direction.NEXT, Mode.SMALLER_STRICT)));
        System.out.println(Arrays.toString(getElementsFromRight(nums, Direction.NEXT, Mode.SMALLER_OR_EQUAL)));

        System.out.println(Arrays.toString(getElementsFromRight(nums, Direction.PREVIOUS, Mode.GREATER_STRICT)));
        System.out.println(Arrays.toString(getElementsFromRight(nums, Direction.PREVIOUS, Mode.GREATER_OR_EQUAL)));
        System.out.println(Arrays.toString(getElementsFromRight(nums, Direction.PREVIOUS, Mode.SMALLER_STRICT)));
        System.out.println(Arrays.toString(getElementsFromRight(nums, Direction.PREVIOUS, Mode.SMALLER_OR_EQUAL)));
    }

    public static int[] nextGreaterElementsFromRight(int[] nums) {
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

    public static int[] nextGreaterElementsFromLeft(int[] nums) {
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

    public static int[] getElementsFromRight(int[] nums, Direction direction, Mode mode) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // stack of values

        if (direction == Direction.NEXT) {
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && shouldPop(stack.peek(), nums[i], mode)) {
                    stack.pop();
                }
                ans[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i]);
            }
        } else {
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && shouldPop(stack.peek(), nums[i], mode)) {
                    stack.pop();
                }
                ans[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i]);
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(stack.toArray()));
        return ans;
    }

    /**
     * Compare top value with cur value based on mode and decide whether the top value should be popped.
     *
     * @param top  top value of the stack
     * @param cur  current value of the given nums
     * @param mode value of enum mode
     * @return whether top value should be popped
     */
    private static boolean shouldPop(int top, int cur, Mode mode) {
        return switch (mode) {
            case GREATER_STRICT -> top <= cur;
            case GREATER_OR_EQUAL -> top < cur;
            case SMALLER_STRICT -> top >= cur;
            case SMALLER_OR_EQUAL -> top > cur;
        };
    }

}
