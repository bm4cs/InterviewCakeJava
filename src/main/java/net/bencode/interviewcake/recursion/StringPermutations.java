package net.bencode.interviewcake.recursion;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringPermutations {

    public static Set<String> getPermutations(String inputString) {

        // base case
        if (inputString.length() <= 1) {
            return new HashSet<>(Collections.singletonList(inputString));
        }

        // do work
        String allCharsExceptLast = inputString.substring(0, inputString.length() - 1);
        char lastChar = inputString.charAt(inputString.length() - 1);

        Set<String> permutationsExceptLastChar = getPermutations(allCharsExceptLast);

        // starting from base case, build results up
        // dont care about smaller subsets (ie combinations) just full word length permutations
        Set<String> permutations = new HashSet<>();

        for (String permutationOfAllCharsExceptLast : permutationsExceptLastChar) {
            for (int position = 0; position <= permutationOfAllCharsExceptLast.length(); position++) {
                String permutation = permutationOfAllCharsExceptLast.substring(0, position) + lastChar
                        + permutationOfAllCharsExceptLast.substring(position);
                permutations.add(permutation);
            }
        }

        return permutations;
    }


}
