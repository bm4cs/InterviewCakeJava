package net.bencode.hackerrank.easy;

/*
 * https://www.hackerrank.com/challenges/a-very-big-sum/problem
 */
public class VeryBigSum {
    static long aVeryBigSum(long[] ar) {
        long r = 0;
        for (long l : ar) {
            r += l;
        }
        return r;
    }
}
