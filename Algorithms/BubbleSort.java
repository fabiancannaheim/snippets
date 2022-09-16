
package Algorithms;

import java.util.Arrays;

/**
 * Bubble sort belongs to the simple and stable
 * sorting algorithms. An array / list is always
 * run through in pairs from left to right in a
 * so-called bubble phase. If a pair is not in correct
 * order, the elements are simply swapped with each
 * other. This is repeated until the entire array
 * has been run through once. The phase then is repeated
 * until the entire array is completely sorted.
 * Worst case time complexity: O(n^2)
 * Average case time complexity: O(n^2)
 * Best case time complexity: O(n)
 */
public class BubbleSort {

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void run(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            boolean swap = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swap = true;
                }
            }
            if (!swap)
                break;
        }
    }

    public static void main(String[] args) {
        int[] array = { 9, 5, 3, 8, 6, 1, 2, 7, 7 };
        BubbleSort.run(array);
        System.out.println(Arrays.toString(array));
    }

}