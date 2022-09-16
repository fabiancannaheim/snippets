
package Algorithms;

import java.util.Arrays;

/**
 * Selection sort belongs to the simple and unstable
 * sort algorithms in computer science. It sorts a
 * certain number of elements by repeatedly finding the
 * minimum (or maximum) element from the unsorted part
 * and putting it at the beginning (or end) of the list / array.
 * Therefore the algorithm maintains two sublists, one which
 * is already sorted and one which is unsorted till now.
 * Worst case time complexity: O(n^2)
 * Average case time complexity: O(n^2)
 * Best case time complexity: O(n^2)
 */
public class SelectionSort {

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static int[] run(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(array, min, i);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = { 9, 5, 3, 8, 6, 1, 2, 7, 7 };
        array = SelectionSort.run(array);
        System.out.println(Arrays.toString(array));
    }

}