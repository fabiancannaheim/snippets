
package Algorithms;

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
        int[] array = new int[9];
        array[0] = 9;
        array[1] = 5;
        array[2] = 3;
        array[3] = 8;
        array[4] = 6;
        array[5] = 1;
        array[6] = 2;
        array[7] = 7;
        array[8] = 7;
        int[] sortedArray = SelectionSort.run(array);
        for (int i : sortedArray) {
            System.out.println(i);
        }
    }

}