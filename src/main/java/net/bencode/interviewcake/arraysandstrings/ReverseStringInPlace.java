package net.bencode.interviewcake.arraysandstrings;

public class ReverseStringInPlace {

    public static void reverse(char[] input) {
        // h e l l o
        // becomes:
        // o l l e h
        char tmp;

        for (int i = 0; i < input.length / 2; i++) {
            tmp = input[i];
            input[i] = input[input.length - (i + 1)];
            input[input.length - (i + 1)] = tmp;
        }
    }
}
