package net.bencode.interviewcake.dynamicandrecursion;

import java.util.HashMap;
import java.util.Map;

public class ComputeFibonacci {

    public static int fib(int n) {
        return fibBottomUp(n);
//        return fibRecursive(n);
    }



    // iterative solution is O(1) space due to more efficient use of call stack
    private static int fibBottomUp(int n) {

        if (n < 0) {
            throw new RuntimeException("index gone negative");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        int fibA = 0;
        int fibB = 1;
        int nthFibonacci = 0;

        for (int i = 2; i <= n; i++) {

            nthFibonacci = fibA + fibB;
            fibA = fibB;
            fibB = nthFibonacci;

        }

        return nthFibonacci;
    }




    private static Map<Integer,Integer> memo = new HashMap<>();

    // O(n) time, O(2^n) doubling space!
    private static int fibRecursive(int n) {

        if (n < 0) {
            throw new RuntimeException("index gone negative");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        // memoization enhancement
        if (memo.containsKey(n)) {
            System.out.printf("memo[%d]\n", n);
            return memo.get(n);
        }

        // start with the end in mind (habit 2)
        System.out.printf("computing fib(%d)\n", n);
        int result = fibRecursive(n - 1) + fibRecursive(n - 2);

        memo.put(n, result);

        return result;
    }


}
