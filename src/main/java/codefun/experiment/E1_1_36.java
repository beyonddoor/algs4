package codefun.experiment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Empirical shuffle check. Run computational experiments to check that our
 * shuffling code on page 32 works as advertised. Write a program ShuffleTest that takes
 * command-line arguments M and N, does N shuffles of an array of size M that is initialized with a[i] = i before each shuffle, and prints an M-by-M table such that row i
 * gives the number of times i wound up in position j for all j. All entries in the array
 * should be close to N/M.
 */
public class E1_1_36 {
    static void test(int arrayLen, int shuffleCount, Consumer<int[]> callable) {
        var array = new int[arrayLen];
        var matrix = new int[arrayLen][arrayLen];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            matrix[i] = new int[arrayLen];
        }

        for (int i = 0; i < shuffleCount; i++) {
            StdRandom.shuffle(array);
            callable.accept(array);
            for (int k = 0; k < array.length; k++) {
                matrix[k][array[k]]++;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                StdOut.printf("%.3f ", matrix[i][j] / (double) shuffleCount);
            }
            StdOut.print("\n");
        }
    }

    public static void shuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // between i and n-1
            int r = i + StdRandom.uniformInt(n-i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * 比较的结果似乎没有差别
     * @param a
     */
    public static void badShuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // between 0 and n-1
            int r = StdRandom.uniformInt(n);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args) {
        int count = 1000;
        int arrayLen = 6;
        test(arrayLen, count, E1_1_36::shuffle);
        StdOut.print("==============================\n");
        test(arrayLen, count, E1_1_36::badShuffle);
    }
}
