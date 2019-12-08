package net.bencode.interviewcake.fundamentals;

public class Logarithms {


    /*
    "How many times must we double 1 before we get to nn" is a question we often ask ourselves in computer science.
    Or, equivalently, "How many times must we divide nn in half in order to get back down to 1?"
    The answer to both of these questions is log2n
     */



    /*
    This comes up in the time cost of binary search
     */
    public static boolean binarySearch(int target, int[] vals) {

        int floorIndex = -1;
        int ceilingIndex = vals.length;

        while (floorIndex + 1 < ceilingIndex) {

            int distance = ceilingIndex - floorIndex;
            int halfDistance = distance / 2;
            int guessIndex = floorIndex + halfDistance;
            int guessValue = vals[guessIndex];

            if (guessValue == target) {
                return true;
            }

            if (guessValue > target) {
                ceilingIndex = guessIndex;
            } else {
                floorIndex = guessIndex;
            }
        }

        return false;
    }

}
