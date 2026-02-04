package org.example.leetcode.global;

import org.example.model.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node">LeetCode 116: Populating Next Right Pointers in Each Node</a>
 * <p>
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition: <br>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. <br>
 * Initially, all next pointers are set to NULL. <br>
 * Follow-up:
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Iterative level traversal using next pointers. <br>
 * - Build the next level using a dummy head. <br>
 * - Move across the current level via next pointers.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space for the dummy and pointers.
 */
public class LeetCode0116_4 {

    public TreeNode connect(TreeNode root) {
        var dummy = new TreeNode();
        var cur = root;
        while (cur != null) {
            dummy.next = null;
            var nxt = dummy; // 下一层的链表
            while (cur != null) { // 遍历当前层的链表
                if (cur.left != null) {
                    nxt.next = cur.left; // 下一层的相邻节点连起来
                    nxt = cur.left;
                }
                if (cur.right != null) {
                    nxt.next = cur.right; // 下一层的相邻节点连起来
                    nxt = cur.right;
                }
                cur = cur.next; // 当前层链表的下一个节点
            }
            cur = dummy.next; // 下一层链表的头节点
        }
        return root;
    }

}
