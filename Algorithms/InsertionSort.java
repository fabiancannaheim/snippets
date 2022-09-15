
package Algorithms;

/**
 * Insertion sort belongs to the stable sorting algorithms.
 * It sorts a certain number of elements by splitting them
 * into a sorted and an unsorted part. Elements from the
 * unsorted part are picked and placed at the correct position
 * in the sorted part. It is one of the simplest sorting algorithms
 * and works efficient for small data sets.
 * Worst case time complexity: O(n^2)
 * Average case time complexity: O(n^2)
 * Best case time complexity: O(n)
 */
public class InsertionSort {

    public static void swap(int[] a, int i, int j) {
        int h = a[i];
        a[i] = a[j];
        a[j] = h;
    }

    public static void run(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(array, j, j - 1);
                j--;
            }
        }
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
        InsertionSort.run(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

}