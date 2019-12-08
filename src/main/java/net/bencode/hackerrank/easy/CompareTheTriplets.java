package net.bencode.hackerrank.easy;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class CompareTheTriplets {
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0, bob = 0;

        for (int i = 0; i < 3; i++) {
            int c = Integer.compare(a.get(i), b.get(i));

            if (c > 0) {
                alice++;
            } else if (c < 0) {
                bob++;
            }
        }

        return Arrays.asList(alice, bob);
    }
}
