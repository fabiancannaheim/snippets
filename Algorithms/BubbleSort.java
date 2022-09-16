
package Algorithms;

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
        BubbleSort.run(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

}