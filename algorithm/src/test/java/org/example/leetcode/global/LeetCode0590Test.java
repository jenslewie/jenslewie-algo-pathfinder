package org.example.leetcode.global;

import org.example.model.tree.NaryTreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 590: N-ary Tree Postorder Traversal")
class LeetCode0590Test {

    private static final LeetCode0590 SOLUTION = new LeetCode0590();

    @ParameterizedTest(name = "[{index}] case={0}")
    @MethodSource("testCases")
    void testPostorder(String caseName, NaryTreeNode root, List<Integer> expected) {
        List<Integer> actual = SOLUTION.postorder(root);
        assertEquals(expected, actual, () -> "Case '%s' failed.".formatted(caseName));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("null_root", null, List.of()),
                Arguments.of("example_tree", buildExampleTree(), List.of(5, 6, 3, 2, 4, 1))
        );
    }

    private static NaryTreeNode buildExampleTree() {
        NaryTreeNode root = new NaryTreeNode(1);
        NaryTreeNode node3 = new NaryTreeNode(3);
        NaryTreeNode node2 = new NaryTreeNode(2);
        NaryTreeNode node4 = new NaryTreeNode(4);
        root.children.add(node3);
        root.children.add(node2);
        root.children.add(node4);

        node3.children.add(new NaryTreeNode(5));
        node3.children.add(new NaryTreeNode(6));

        return root;
    }
}
