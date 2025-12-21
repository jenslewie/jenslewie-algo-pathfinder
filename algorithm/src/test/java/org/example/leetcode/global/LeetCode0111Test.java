package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0111Test {

    private LeetCode0111 leetCode;
    private TreeNode root;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0111();
    }

    @Test
    void test1() {
        root = BinaryTreeBuilder.buildTree(new Integer[] {}, 0);
        assertEquals(0, leetCode.minDepth(root));
    }

    @Test
    void test2() {
        root = BinaryTreeBuilder.buildTree(new Integer[] {1}, 0);
        assertEquals(1, leetCode.minDepth(root));
    }

    @Test
    void test3() {
        root = BinaryTreeBuilder.buildTree(new Integer[] {1, null, 3, null, null, null, 7}, 0);
        assertEquals(3, leetCode.minDepth(root));
    }
}
