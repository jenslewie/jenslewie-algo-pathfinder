package org.example.tree.narytree;

import org.example.builder.NaryTreeBuilder;
import org.example.learning.tree.narytree.BreadthFirstSearch;
import org.example.model.tree.NaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BreadthFirstSearchTest {

    private BreadthFirstSearch bfs;
    private NaryTreeNode root;

    @BeforeEach
    public void setUp() {
        bfs = new BreadthFirstSearch();
    }

    @Test
    void test1() {
        NaryTreeBuilder.buildNaryTree(new Integer[] {1});
    }
}
