package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode 49: Group Anagrams - Algorithm Variants")
class LeetCode0049Test {

    private static final LeetCode0049_1 SOLUTION_1 = new LeetCode0049_1();
    private static final LeetCode0049_2 SOLUTION_2 = new LeetCode0049_2();
    private static final LeetCode0049_3 SOLUTION_3 = new LeetCode0049_3();
    private static final LeetCode0049_4 SOLUTION_4 = new LeetCode0049_4();

    @FunctionalInterface
    interface GroupAnagramsFunction {
        List<List<String>> apply(String[] strs);
    }

    private static final Map<String, GroupAnagramsFunction> ALGO_VARIANTS = Map.of(
            "hash_map_frequency", SOLUTION_1::groupAnagrams,
            "sorted_string_key", SOLUTION_2::groupAnagrams,
            "character_count_encoding", SOLUTION_3::groupAnagrams,
            "stream_api", SOLUTION_4::groupAnagrams
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, strs={2}")
    @MethodSource("allCombinations")
    void testGroupAnagrams(String caseName, String algoName, String[] strs, List<List<String>> expected) {
        List<List<String>> actual = ALGO_VARIANTS.get(algoName).apply(strs);

        // Sort both expected and actual for comparison (order doesn't matter)
        List<Set<String>> expectedSets = convertToSortedSets(expected);
        List<Set<String>> actualSets = convertToSortedSets(actual);

        assertEquals(expectedSets.size(), actualSets.size(),
                () -> "Case '%s' with algo='%s' failed. Expected %d groups but got %d"
                        .formatted(caseName, algoName, expectedSets.size(), actualSets.size()));

        for (Set<String> expectedSet : expectedSets) {
            assertTrue(actualSets.contains(expectedSet),
                    () -> "Case '%s' with algo='%s' failed. Missing group: %s"
                            .formatted(caseName, algoName, expectedSet));
        }
    }

    private static List<Set<String>> convertToSortedSets(List<List<String>> lists) {
        return lists.stream()
                .map(list -> (Set<String>) new HashSet<>(list))
                .sorted(Comparator.comparing(Object::toString))
                .toList();
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.strs, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1",
                        new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        List.of(
                                List.of("bat"),
                                List.of("nat", "tan"),
                                List.of("ate", "eat", "tea")
                        )),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new String[]{""},
                        List.of(
                                List.of("")
                        )),

                // Example 3 from LeetCode
                new TestCase("example_3",
                        new String[]{"a"},
                        List.of(
                                List.of("a")
                        )),

                // All same anagram
                new TestCase("all_same_anagram",
                        new String[]{"abc", "bca", "cab", "acb"},
                        List.of(
                                List.of("abc", "bca", "cab", "acb")
                        )),

                // No anagrams
                new TestCase("no_anagrams",
                        new String[]{"a", "b", "c", "d"},
                        List.of(
                                List.of("a"),
                                List.of("b"),
                                List.of("c"),
                                List.of("d")
                        )),

                // Multiple groups
                new TestCase("multiple_groups",
                        new String[]{"listen", "silent", "hello", "world", "dolly", "llody"},
                        List.of(
                                List.of("listen", "silent"),
                                List.of("hello"),
                                List.of("world"),
                                List.of("dolly", "llody")
                        )),

                // Different lengths
                new TestCase("different_lengths",
                        new String[]{"a", "ab", "abc", "ba", "cba", "bca"},
                        List.of(
                                List.of("a"),
                                List.of("ab", "ba"),
                                List.of("abc", "cba", "bca")
                        )),

                // Edge case from LeetCode0049_3
                new TestCase("repeated_characters",
                        new String[]{"ddddddddddg", "dgggggggggg"},
                        List.of(
                                List.of("ddddddddddg"),
                                List.of("dgggggggggg")
                        )),

                // Empty array
                new TestCase("empty_array",
                        new String[]{},
                        List.of()),

                // Mixed case sensitivity (all lowercase)
                new TestCase("all_lowercase",
                        new String[]{"abc", "bca", "xyz", "zyx"},
                        List.of(
                                List.of("abc", "bca"),
                                List.of("xyz", "zyx")
                        ))
        );
    }

    private record TestCase(String name, String[] strs, List<List<String>> expected) {
    }

}
