package net.bencode.interviewcake.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PermutationPalindrome {


    // 2nd attempt
    // O(n) time O(n) space
    public static boolean check(String input) {

        Set<Character> characterSet = new HashSet<>();

        // only care about even or odd occurrences of characters
        for (char theChar : input.toCharArray()) {
            if (characterSet.contains(theChar)) {
                characterSet.remove(theChar);
            }
            else {
                characterSet.add(theChar);
            }
        }

        return characterSet.size() <= 1;
    }


    public static boolean checkFirstAttempt(String input) {


        HashMap<Character, Integer> characterHash = new HashMap<>();

        // log count of each character
        for (char currentChar : input.toCharArray()) {
            if (characterHash.containsKey(currentChar)) {
                int currentCount = characterHash.get(currentChar) + 1;
                characterHash.replace(currentChar, currentCount);
            }
            else {
                characterHash.put(currentChar, 1);
            }
        }

        // evaluate results
        boolean singleFound = false;
        for (int value : characterHash.values()) {

            if (value % 2 != 0) {
                if (value == 1 && !singleFound) {
                    singleFound = true;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }

}
