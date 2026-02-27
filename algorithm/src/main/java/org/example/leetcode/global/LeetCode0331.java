package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree">LeetCode 331: Verify Preorder Serialization of a Binary Tree</a>
 * <p>
 * One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as '#'. <br>
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node. <br>
 * Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree. <br>
 * It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer. <br>
 * You may assume that the input format is always valid. <br>
 * For example, it could never contain two consecutive commas, such as "1,,3". <br>
 * Note: You are not allowed to reconstruct the tree.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Degree-difference scan over preorder tokens. <br>
 * - Start with one incoming slot for the root. <br>
 * - Each token consumes one slot; non-null node adds two new child slots.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of tokens in preorder string.
 * <p>
 * Space Complexity: O(n) <br>
 * - Split operation stores tokens.
 */
public class LeetCode0331 {

    public boolean isValidSerialization(String preorder) {
        int edge = 1;
        for (String node : preorder.split(",")) {
            if ("#".equals(node)) {
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
            } else {
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
                edge += 2;
            }
        }
        return edge == 0;
    }

}
