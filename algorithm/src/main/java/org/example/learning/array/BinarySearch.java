package org.example.learning.array;

import java.util.Arrays;

/**
 * <a href="https://labuladong.online/algo/essential-technique/binary-search-framework">...</a>
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arrInAsc = {0, 1, 2, 3, 4, 5, 5, 5, 5, 5, 6, 8, 9};
        int[] arrInDesc = {9, 8, 6, 5, 5, 5, 5, 5, 4, 3, 2, 1, 0};

        int result = binarySearch(arrInDesc, 5);
        System.out.println("Target 5 is located at: " + result);
        result = binarySearch(arrInDesc, 10);
        System.out.println("Target 10 is located at: " + result);
        System.out.println();

        System.out.println(Arrays.toString(arrInAsc));
        result = binarySearchForLeftBoundary(arrInAsc, 5, true);
        System.out.println("Left boundary of target 5 is located at: " + result);
        result = binarySearchForLeftBoundary(arrInAsc, 7, true);
        System.out.println("Left boundary of target 7 located at: " + result);
        result = binarySearchForLeftBoundary(arrInAsc, 10, true);
        System.out.println("Left boundary of target 10 is located at: " + result);
        System.out.println();

        System.out.println(Arrays.toString(arrInDesc));
        result = binarySearchForLeftBoundary(arrInDesc, 5, false);
        System.out.println("Left boundary of target 5 is located at: " + result);
        result = binarySearchForLeftBoundary(arrInDesc, 7, false);
        System.out.println("Left boundary of target 7 located at: " + result);
        result = binarySearchForLeftBoundary(arrInDesc, 10, false);
        System.out.println("Left boundary of target 10 is located at: " + result);
        System.out.println();

        System.out.println(Arrays.toString(arrInAsc));
        result = binarySearchForLeftBoundary2(arrInAsc, 5, true);
        System.out.println("Left boundary of target 5 is located at: " + result);
        result = binarySearchForLeftBoundary2(arrInAsc, 7, true);
        System.out.println("Left boundary of target 7 located at: " + result);
        result = binarySearchForLeftBoundary2(arrInAsc, 10, true);
        System.out.println("Left boundary of target 10 is located at: " + result);
        System.out.println();

        System.out.println(Arrays.toString(arrInDesc));
        result = binarySearchForLeftBoundary2(arrInDesc, 5, false);
        System.out.println("Left boundary of target 5 is located at: " + result);
        result = binarySearchForLeftBoundary2(arrInDesc, 7, false);
        System.out.println("Left boundary of target 7 located at: " + result);
        result = binarySearchForLeftBoundary2(arrInDesc, 10, false);
        System.out.println("Left boundary of target 10 is located at: " + result);
        System.out.println();

        System.out.println(Arrays.toString(arrInAsc));
        result = binarySearchForRightBoundary(arrInAsc, 5, true);
        System.out.println("Right boundary of target 5 is located at: " + result);
        result = binarySearchForRightBoundary(arrInAsc, 7, true);
        System.out.println("Right boundary of target 7 is located at: " + result);
        result = binarySearchForRightBoundary(arrInAsc, 10, true);
        System.out.println("Right boundary of target 10 is located at: " + result);
        System.out.println();

        System.out.println(Arrays.toString(arrInDesc));
        result = binarySearchForRightBoundary(arrInDesc, 5, false);
        System.out.println("Right boundary of target 5 is located at: " + result);
        result = binarySearchForRightBoundary(arrInDesc, 7, false);
        System.out.println("Right boundary of target 7 is located at: " + result);
        result = binarySearchForRightBoundary(arrInDesc, 10, false);
        System.out.println("Right boundary of target 10 is located at: " + result);
        System.out.println();

        System.out.println(Arrays.toString(arrInAsc));
        result = binarySearchForRightBoundary2(arrInAsc, 5, true);
        System.out.println("Right boundary of target 5 is located at: " + result);
        result = binarySearchForRightBoundary2(arrInAsc, 7, true);
        System.out.println("Right boundary of target 7 is located at: " + result);
        result = binarySearchForRightBoundary2(arrInAsc, 10, true);
        System.out.println("Right boundary of target 10 is located at: " + result);
        System.out.println();

        System.out.println(Arrays.toString(arrInDesc));
        result = binarySearchForRightBoundary2(arrInDesc, 5, false);
        System.out.println("Right boundary of target 5 is located at: " + result);
        result = binarySearchForRightBoundary2(arrInDesc, 7, false);
        System.out.println("Right boundary of target 7 is located at: " + result);
        result = binarySearchForRightBoundary2(arrInDesc, 10, false);
        System.out.println("Right boundary of target 10 is located at: " + result);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchForLeftBoundary(int[] arr, int target, boolean isAscending) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean moveLeft = isAscending ? target <= arr[mid] : target >= arr[mid];
            if (moveLeft) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < 0 || left >= arr.length) {
            return -1;
        }
        return arr[left] == target ? left : -1;
    }

    public static int binarySearchForLeftBoundary2(int[] arr, int target, boolean isAscending) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean moveLeft = isAscending ? target <= arr[mid] : target >= arr[mid];
            if (moveLeft) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left < 0 || left >= arr.length) {
            return -1;
        }
        return arr[left] == target ? left : -1;
    }

    public static int binarySearchForRightBoundary(int[] arr, int target, boolean isAscending) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean moveRight = isAscending ? target >= arr[mid] : target <= arr[mid];
            if (moveRight) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0 || right >= arr.length) {
            return -1;
        }
        return arr[right] == target ? right : -1;
    }

    public static int binarySearchForRightBoundary2(int[] arr, int target, boolean isAscending) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean moveRight = isAscending ? target >= arr[mid] : target <= arr[mid];
            if (moveRight) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (right - 1 < 0 || right - 1 >= arr.length) {
            return -1;
        }
        return arr[right - 1] == target ? right - 1 : -1;
    }

}
