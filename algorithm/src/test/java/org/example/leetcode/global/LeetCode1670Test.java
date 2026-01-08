package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 1670: Design Front Middle Back Queue - Algorithm Variants")
class LeetCode1670Test {

    @FunctionalInterface
    interface FrontMiddleBackQueueFunction {
        List<Object> apply(List<String> ops, List<List<Integer>> args);
    }

    private static final Map<String, FrontMiddleBackQueueFunction> ALGO_VARIANTS = Map.of(
            "doubly_linked_list", LeetCode1670Test::executeV1,
            "dual_deque", LeetCode1670Test::executeV2
    );

    @ParameterizedTest(name = "[{index}] {0}, algo={1}, ops={2}, args={3}")
    @MethodSource("allCombinations")
    void testFrontMiddleBackQueue(String caseName, String algoName, List<String> ops, List<List<Integer>> args, List<Object> expected) {
        List<Object> actual = ALGO_VARIANTS.get(algoName).apply(ops, args);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. ops=%s, args=%s"
                .formatted(caseName, algoName, ops, args));
    }

    // --- V1: Doubly Linked List ---
    private static List<Object> executeV1(List<String> ops, List<List<Integer>> args) {
        LeetCode1670_1 queue = null;
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < ops.size(); i++) {
            String op = ops.get(i);
            if ("FrontMiddleBackQueue".equals(op)) {
                queue = new LeetCode1670_1();
                result.add(null);
            } else if ("pushFront".equals(op)) {
                queue.pushFront(args.get(i).get(0));
                result.add(null);
            } else if ("pushMiddle".equals(op)) {
                queue.pushMiddle(args.get(i).get(0));
                result.add(null);
            } else if ("pushBack".equals(op)) {
                queue.pushBack(args.get(i).get(0));
                result.add(null);
            } else if ("popFront".equals(op)) {
                result.add(queue.popFront());
            } else if ("popMiddle".equals(op)) {
                result.add(queue.popMiddle());
            } else if ("popBack".equals(op)) {
                result.add(queue.popBack());
            }
        }
        return result;
    }

    // --- V2: Dual Deque ---
    private static List<Object> executeV2(List<String> ops, List<List<Integer>> args) {
        LeetCode1670_2 queue = null;
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < ops.size(); i++) {
            String op = ops.get(i);
            if ("FrontMiddleBackQueue".equals(op)) {
                queue = new LeetCode1670_2();
                result.add(null);
            } else if ("pushFront".equals(op)) {
                queue.pushFront(args.get(i).get(0));
                result.add(null);
            } else if ("pushMiddle".equals(op)) {
                queue.pushMiddle(args.get(i).get(0));
                result.add(null);
            } else if ("pushBack".equals(op)) {
                queue.pushBack(args.get(i).get(0));
                result.add(null);
            } else if ("popFront".equals(op)) {
                result.add(queue.popFront());
            } else if ("popMiddle".equals(op)) {
                result.add(queue.popMiddle());
            } else if ("popBack".equals(op)) {
                result.add(queue.popBack());
            }
        }
        return result;
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.ops, tc.args, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // LeetCode Example 1
                new TestCase("example_1",
                        List.of("FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle",
                                "popFront", "popMiddle", "popMiddle", "popBack", "popFront"),
                        List.of(
                                List.of(),
                                List.of(1),
                                List.of(2),
                                List.of(3),
                                List.of(4)
                        ),
                        Arrays.asList(null, null, null, null, null, 1, 3, 4, 2, -1)
                ),

                // Your Test Case 1
                new TestCase("test_case_1",
                        List.of("FrontMiddleBackQueue", "pushMiddle", "popMiddle", "pushMiddle",
                                "popMiddle", "pushFront", "pushMiddle", "pushMiddle", "popMiddle", "popMiddle", "pushBack", "popMiddle"),
                        List.of(
                                List.of(),
                                List.of(493299),
                                List.of(),
                                List.of(75427),
                                List.of(),
                                List.of(753523),
                                List.of(677444),
                                List.of(431158),
                                List.of(),
                                List.of(),
                                List.of(47949),
                                List.of()
                        ),
                        Arrays.asList(null, null, 493299, null, 75427, null, null, null, 431158, 677444, null, 753523)
                ),

                // Your Test Case 2 (Expected computed per LeetCode rules)
                new TestCase("test_case_2",
                        List.of("FrontMiddleBackQueue", "popMiddle", "popMiddle", "pushMiddle",
                                "pushMiddle", "popMiddle", "popMiddle", "popMiddle", "popBack", "popMiddle",
                                "popFront", "pushBack", "popFront", "pushMiddle", "pushMiddle", "popMiddle",
                                "popBack", "pushFront", "popMiddle", "pushMiddle", "pushMiddle", "pushMiddle",
                                "popMiddle", "pushMiddle", "popBack", "pushMiddle", "popMiddle", "popMiddle",
                                "popMiddle", "popMiddle", "popFront", "pushMiddle", "pushMiddle", "pushMiddle", "pushFront"),
                        List.of(
                                List.of(),
                                List.of(),
                                List.of(),
                                List.of(773222),
                                List.of(279355),
                                List.of(),
                                List.of(),
                                List.of(),
                                List.of(),
                                List.of(),
                                List.of(),
                                List.of(448905),
                                List.of(),
                                List.of(168284),
                                List.of(874541),
                                List.of(),
                                List.of(),
                                List.of(15656),
                                List.of(),
                                List.of(803226),
                                List.of(720129),
                                List.of(626048),
                                List.of(),
                                List.of(860306),
                                List.of(),
                                List.of(630886),
                                List.of(),
                                List.of(),
                                List.of(),
                                List.of(),
                                List.of(),
                                List.of(837735),
                                List.of(414354),
                                List.of(404946),
                                List.of(88719)
                        ),
                        Arrays.asList(
                                null,
                                -1, -1,
                                null, null,
                                279355, 773222,
                                -1, -1, -1, -1,
                                null,
                                448905,
                                null, null,
                                874541,
                                168284,
                                null,
                                15656,
                                null, null, null,
                                626048,
                                null,
                                803226,
                                null,
                                630886,
                                720129,
                                860306,
                                -1,
                                -1,
                                null, null, null, null
                        )
                )
        );
    }

    private record TestCase(String name, List<String> ops, List<List<Integer>> args, List<Object> expected) {
    }

}
