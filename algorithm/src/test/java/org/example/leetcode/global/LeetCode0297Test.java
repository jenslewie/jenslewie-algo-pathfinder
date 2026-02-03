package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.leetcode.utility.BinaryTreeUtility;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode 297: Serialize and Deserialize Binary Tree")
class LeetCode0297Test {

    interface Codec {
        String serialize(TreeNode root);

        TreeNode deserialize(String data);
    }

    private static final Map<String, Codec> ALGO_VARIANTS = Map.of(
            "dfs_preorder_recursive",
            new Codec() {
                private final LeetCode0297_1 impl = new LeetCode0297_1();

                public String serialize(TreeNode root) {
                    return impl.serialize(root);
                }

                public TreeNode deserialize(String data) {
                    return impl.deserialize(data);
                }
            },

            "dfs_postorder_recursive",
            new Codec() {
                private final LeetCode0297_2 impl = new LeetCode0297_2();

                public String serialize(TreeNode root) {
                    return impl.serialize(root);
                }

                public TreeNode deserialize(String data) {
                    return impl.deserialize(data);
                }
            },

            "bfs_level_order_iterative",
            new Codec() {
                private final LeetCode0297_3 impl = new LeetCode0297_3();

                public String serialize(TreeNode root) {
                    return impl.serialize(root);
                }

                public TreeNode deserialize(String data) {
                    return impl.deserialize(data);
                }
            }
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, tree={2}")
    @MethodSource("allCombinations")
    void testSerializeDeserialize(String caseName, String algoName, Integer[] treeArray) {
        TreeNode original = BinaryTreeBuilder.build(treeArray);
        Codec codec = ALGO_VARIANTS.get(algoName);

        String serialized = codec.serialize(original);
        TreeNode deserialized = codec.deserialize(serialized);

        assertTrue(BinaryTreeUtility.isSameTree(original, deserialized),
                () -> String.format("Round-trip failed for case '%s' with algo='%s'.", caseName, algoName));
    }

    @Test
    void testDeserializeEmptyString() {
        for (var entry : ALGO_VARIANTS.entrySet()) {
            TreeNode result = entry.getValue().deserialize("");
            assertNull(result, () -> "Expected null for empty input with algo=" + entry.getKey());
        }
    }

    @Test
    void testDeserializeNullString() {
        for (var entry : ALGO_VARIANTS.entrySet()) {
            TreeNode result = entry.getValue().deserialize(null);
            assertNull(result, () -> "Expected null for null input with algo=" + entry.getKey());
        }
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new Integer[]{1, 2, 3, null, null, 4, 5}),
                new TestCase("example_2", new Integer[]{}),
                new TestCase("example_3", new Integer[]{1}),

                // === Edge Cases ===
                new TestCase("empty_tree", new Integer[]{}),
                new TestCase("single_node", new Integer[]{42}),
                new TestCase("only_left_child", new Integer[]{1, 2}),
                new TestCase("only_right_child", new Integer[]{1, null, 2}),

                // === Skewed Trees ===
                new TestCase("left_skewed_4", new Integer[]{1, 2, null, 3, null, null, null, 4}),
                new TestCase("right_skewed_4", new Integer[]{1, null, 2, null, null, null, 3, null, null, null, null, null, null, null, 4}),

                // === Full Binary Trees ===
                new TestCase("full_depth_2", new Integer[]{1, 2, 3}),
                new TestCase("full_depth_3", new Integer[]{1, 2, 3, 4, 5, 6, 7}),

                // === Complex Asymmetric Trees ===
                new TestCase("complex_1", new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7}),
                new TestCase("complex_2", new Integer[]{5, 3, 8, 2, 4, 7, 9, 1, null, null, null, 6}),

                // === All Null Except Root ===
                new TestCase("root_with_null_children", new Integer[]{1, null, null}),

                // === Deep Tree with Mixed Structure ===
                new TestCase("deep_mixed", new Integer[]{10, 5, 15, 3, 7, null, 18, 1, null, 6})
        );
    }

    private record TestCase(String name, Integer[] treeArray) {
    }

}
