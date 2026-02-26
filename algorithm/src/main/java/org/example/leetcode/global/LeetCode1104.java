package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree">LeetCode 1104: Path In Zigzag Labelled Binary Tree</a>
 * <p>
 * In an infinite binary tree where every node has two children, the nodes are labelled in row order. <br>
 * In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left. <br>
 * Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Reverse path construction using mirrored label mapping per level. <br>
 * - Walk upward from label to root. <br>
 * - For each level, map zigzag label to mirrored normal label range, then move to parent.
 * <p>
 * Time Complexity: O(log label) <br>
 * - One step per tree level from node to root.
 * <p>
 * Space Complexity: O(log label) <br>
 * - Stores nodes on the root path.
 */
public class LeetCode1104 {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        while (label >= 1) {
            ans.add(label);
            int depth = getDepth(label);
            int[] range = getRange(depth);
            int mirrored = range[0] + range[1] - label;
            label = mirrored / 2;
        }
        Collections.reverse(ans);
        return ans;
    }

    private int[] getRange(int depth) {
        int start = (int) Math.pow(2, depth);
        return new int[]{start, start * 2 - 1};
    }

    private int getDepth(int label) {
        return (int) (Math.log(label) / Math.log(2));
    }

}
