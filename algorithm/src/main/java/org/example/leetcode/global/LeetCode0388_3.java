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
 * Approach: Split and stack of directory names. <br>
 * - Split input by newlines and track depth by tabs. <br>
 * - Compute path length when a file is seen.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the input string; splitting and scanning are linear.
 * <p>
 * Space Complexity: O(d) <br>
 * - d: maximum directory depth stored in the stack.
 */
public class LeetCode0388_3 {

    public int lengthLongestPath(String input) {
        int maxLen = 0;
        Stack<String> stack = new Stack<>();
        for (String item : input.split("\n")) {
            int level = item.lastIndexOf("\t") + 1;
            while (level < stack.size()) {
                stack.pop();
            }
            stack.add(item.substring(level));
            if (item.contains(".")) {
                int sum = stack.stream().mapToInt(String::length).sum();
                sum += stack.size() - 1;
                maxLen = Math.max(maxLen, sum);
            }
        }
        return maxLen;
    }
}
