package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal">LeetCode 144: Binary Tree Preorder Traversal</a>
 * <p>
 * Approach: Recursive traversal returning lists. <br>
 * - Visit root, then concatenate left and right traversals. <br>
 * - Build the result through recursive list merging.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(h) <br>
 * - h: height of the tree due to recursion stack.
 */
public class LeetCode0144_2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        var ans = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }

        ans.add(root.val);
        ans.addAll(preorderTraversal(root.left));
        ans.addAll(preorderTraversal(root.right));
        return ans;
    }

}
