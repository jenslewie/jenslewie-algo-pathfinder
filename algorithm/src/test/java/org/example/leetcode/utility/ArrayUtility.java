package org.example.leetcode.utility;

import java.util.Arrays;

public class ArrayUtility {

    public static int[][] deepClone(int[][] original) {
        return Arrays.stream(original)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    public static String matrixToString(int[][] mat) {
        if (mat == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < mat.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(Arrays.toString(mat[i]));
        }
        sb.append("]");
        return sb.toString();
    }
}
