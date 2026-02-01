package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 225: Implement Stack using Queues - Algorithm Variants")
class LeetCode0225Test {

    interface StackOperations {
        void push(int x);

        int pop();

        int top();

        boolean empty();
    }

    private static final Map<String, Supplier<StackOperations>> ALGO_VARIANTS = Map.of(
            "single_queue",
            () -> {
                LeetCode0225_1 stack = new LeetCode0225_1();
                return new StackOperations() {
                    @Override
                    public void push(int x) {
                        stack.push(x);
                    }

                    @Override
                    public int pop() {
                        return stack.pop();
                    }

                    @Override
                    public int top() {
                        return stack.top();
                    }

                    @Override
                    public boolean empty() {
                        return stack.empty();
                    }
                };
            },
            "dual_queue",
            () -> {
                LeetCode0225_2 stack = new LeetCode0225_2();
                return new StackOperations() {
                    @Override
                    public void push(int x) {
                        stack.push(x);
                    }

                    @Override
                    public int pop() {
                        return stack.pop();
                    }

                    @Override
                    public int top() {
                        return stack.top();
                    }

                    @Override
                    public boolean empty() {
                        return stack.empty();
                    }
                };
            }
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, ops={2}")
    @MethodSource("allCombinations")
    void testStack(String caseName, String algoName, String[] operations, Object[][] params, Object[] expected) {
        StackOperations stack = ALGO_VARIANTS.get(algoName).get();
        List<Object> actual = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            Object result = null;

            switch (op) {
                case "push":
                    stack.push((Integer) params[i][0]);
                    break;
                case "pop":
                    result = stack.pop();
                    break;
                case "top":
                    result = stack.top();
                    break;
                case "empty":
                    result = stack.empty();
                    break;
                case "MyStack":
                    // Constructor is called via Supplier
                    break;
                default:
                    throw new IllegalArgumentException("Unknown operation: " + op);
            }
            actual.add(result);
        }

        Object[] actualArr = actual.toArray(new Object[0]);
        assertEquals(expected.length, actualArr.length,
                () -> "Output length mismatch in case '%s' with algo='%s'".formatted(caseName, algoName));

        for (int i = 0; i < expected.length; i++) {
            int finalI = i;
            assertEquals(expected[i], actualArr[i], () -> "Mismatch at index %d in case '%s' (algo='%s'): expected=%s, actual=%s"
                    .formatted(finalI, caseName, algoName, expected[finalI], actualArr[finalI]));
        }
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.operations, tc.params, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase("example_1",
                        new String[]{"MyStack", "push", "push", "top", "pop", "empty"},
                        new Object[][]{{}, {1}, {2}, {}, {}, {}},
                        new Object[]{null, null, null, 2, 2, false}),

                new TestCase("single_element",
                        new String[]{"MyStack", "push", "top", "pop", "empty"},
                        new Object[][]{{}, {5}, {}, {}, {}},
                        new Object[]{null, null, 5, 5, true}),

                new TestCase("multiple_ops",
                        new String[]{"MyStack", "push", "push", "push", "pop", "top", "pop", "empty"},
                        new Object[][]{{}, {10}, {20}, {30}, {}, {}, {}, {}},
                        new Object[]{null, null, null, null, 30, 20, 20, false}),

                new TestCase("empty_stack",
                        new String[]{"MyStack", "empty", "push", "empty", "pop", "empty"},
                        new Object[][]{{}, {}, {100}, {}, {}, {}},
                        new Object[]{null, true, null, false, 100, true}),

                new TestCase("top_only",
                        new String[]{"MyStack", "push", "push", "top", "top", "pop", "top"},
                        new Object[][]{{}, {7}, {8}, {}, {}, {}, {}},
                        new Object[]{null, null, null, 8, 8, 8, 7})
        );
    }

    private record TestCase(String name, String[] operations, Object[][] params, Object[] expected) {
    }

}