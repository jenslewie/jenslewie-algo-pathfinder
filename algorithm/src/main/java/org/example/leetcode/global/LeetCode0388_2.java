package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/longest-absolute-file-path">LeetCode 388: Longest Absolute File Path</a>
 * <p>
 * Suppose we have a file system that stores both files and directories. An example of one system is represented in the following picture: <br>
 * Here, we have dir as the only directory in the root. dir contains two subdirectories, subdir1 and subdir2. subdir1 contains a file file1.ext and subdirectory subsubdir1. subdir2 contains a subdirectory subsubdir2, which contains a file file2.ext. <br>
 * In text form, it looks like this (with ⟶ representing the tab character): <br>
 * If we were to write this representation in code, it will look like this: "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext". Note that the '\n' and '\t' are the new-line and tab characters. <br>
 * Every file and directory has a unique absolute path in the file system, which is the order of directories that must be opened to reach the file/directory itself, all concatenated by '/'s. Using the above example, the absolute path to file2.ext is "dir/subdir2/subsubdir2/file2.ext". Each directory name consists of letters, digits, and/or spaces. Each file name is of the form name.extension, where name and extension consist of letters, digits, and/or spaces. <br>
 * Given a string input representing the file system in the explained format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0. <br>
 * Note that the testcases are generated such that the file system is valid and no file or directory name has length 0.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Stack of path lengths. <br>
 * - Maintain a stack of cumulative lengths by depth. <br>
 * - Update max length when a file is parsed.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the input string; single pass parsing.
 * <p>
 * Space Complexity: O(d) <br>
 * - d: maximum directory depth.
 */
public class LeetCode0388_2 {

    public int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0, ans = 0;
        Stack<Integer> stack = new Stack<>();

        while (pos < n) {
            int depth = 1;
            if (input.charAt(pos) == '\t') {
                while (input.charAt(pos) == '\t') {
                    pos++;
                    depth++;
                }
            }

            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                pos++;
                len++;
            }

            pos++;
            while (stack.size() >= depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stack.push(len);
            }
        }

        return ans;
    }
}
