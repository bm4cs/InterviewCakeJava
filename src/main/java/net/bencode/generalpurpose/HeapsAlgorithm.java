package net.bencode.generalpurpose;

import java.util.Arrays;

public class HeapsAlgorithm {

    private static int depth = 0;

    public static void permutationsHeapsAlgo(int[] list, int n) {


        System.out.printf("  ".repeat(depth++) + "permutationsHeapsAlgo(%d)\n", n);

        if (n == 1) {
            System.out.println(Arrays.toString(list));
        }
        else {
            for (int i = 0; i < n; i++) {
                permutationsHeapsAlgo(list, n-1);

                int j = (n % 2 == 0) ? i : 0;
                int tmp = list[n - 1];
                list[n - 1] = list[j];
                list[j] = tmp;

                System.out.printf("  ".repeat(depth) + "switching element %d and %d\n", j, n-1);
            }
        }

        depth--;
    }

/*
permutationsHeapsAlgo(3)
  permutationsHeapsAlgo(2)
    permutationsHeapsAlgo(1)
[1, 2, 3]
    switching element 0 and 1
    permutationsHeapsAlgo(1)
[2, 1, 3]
    switching element 1 and 1
  switching element 0 and 2
  permutationsHeapsAlgo(2)
    permutationsHeapsAlgo(1)
[3, 1, 2]
    switching element 0 and 1
    permutationsHeapsAlgo(1)
[1, 3, 2]
    switching element 1 and 1
  switching element 0 and 2
  permutationsHeapsAlgo(2)
    permutationsHeapsAlgo(1)
[2, 3, 1]
    switching element 0 and 1
    permutationsHeapsAlgo(1)
[3, 2, 1]
    switching element 1 and 1
  switching element 0 and 2
*/

}
