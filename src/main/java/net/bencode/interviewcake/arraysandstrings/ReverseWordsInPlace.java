package net.bencode.interviewcake.arraysandstrings;

import java.util.Arrays;

public class ReverseWordsInPlace {

    public static void reverseWords(char[] cipherText) {

        // landed has eagle the
        //becomes
        // the eagle has landed

        // character reverse everything in-place
        reverseRange(cipherText, 0, cipherText.length - 1);

        int lowerIndex = 0;
        int upperIndex = 0;
        int currentIndex = 0;

        while (currentIndex < cipherText.length) {

            if (cipherText[currentIndex] == ' ' || currentIndex == cipherText.length - 1) {

                // don't flip white spaces, so back off by one
                upperIndex = currentIndex - 1;

                // edge case, end of string doesn't end in a blank space
                if (currentIndex == cipherText.length - 1) upperIndex++;

                reverseRange(cipherText, lowerIndex, upperIndex);

                // not interested in white space for next word, so move it forward by one
                lowerIndex = currentIndex + 1;

            }

            currentIndex++;
        }
    }

    private static void reverseRange(char[] text, int startIndex, int endIndex) {

        while (startIndex < endIndex) {

            char tmp = text[startIndex];
            text[startIndex] = text[endIndex];
            text[endIndex] = tmp;
            startIndex++;
            endIndex--;

        }
    }
}
