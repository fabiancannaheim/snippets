
package Algorithms;

/**
 * "Towers of Hanoi" is a mathematical problem
 * which is considered as prime example for the
 * principle of "divide & conquer" in programming.
 * 
 * The game consists of three equally sized rods
 * A, B and C, on which several perforated discs
 * are placed, all of different sizes. At the
 * beginning, all discs are on bar A, ordered by
 * size, with the largest disc at the bottom and
 * the smallest on the top. The object is to move
 * the entire stack of disks from A to C. At each
 * turn, the top disk of any bar may be placed on
 * one of the other two bars, provided that there
 * is not already a smaller disk there. Consequently,
 * at any point in the game, the discs on each rod
 * are in order of size.
 * 
 * This problem is a wonderful example for the
 * beauty of recursive solutions.
 */
public class TowersOfHanoi {

    private static String moveDisk(char a, char b, char c, int n) {
        String result;
        if (n == 1) {
            result = a + " => " + c + "\n";
        } else {
            result = moveDisk('A', 'C', 'B', n - 1);
            result += moveDisk('A', 'B', 'C', 1);
            result += moveDisk('B', 'A', 'C', n - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int depth = 3;
        String solution = "\nMove " + depth + " disks from tower A to tower C:\n\n";
        System.out.println(solution + TowersOfHanoi.moveDisk('A', 'B', 'C', depth));
    }

}
