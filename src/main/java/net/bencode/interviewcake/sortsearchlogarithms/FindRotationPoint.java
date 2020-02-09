package net.bencode.interviewcake.sortsearchlogarithms;

public class FindRotationPoint {

    public static int findRotationPoint(String[] words) {

        // find the rotation point in the array

        String midWord = words[0];

        int floor = -1;
        int ceiling = words.length;

        while (floor + 1 < ceiling) {
            int distance = ceiling - floor;
            int halfDistance = distance / 2;
            int guessIndex = floor + halfDistance;
            String guessWord = words[guessIndex];

            if (midWord.compareTo(guessWord) <= 0) {
                floor = guessIndex;
            }
            else {
                ceiling = guessIndex;
            }
        }

        if (floor != -1 && midWord.compareTo(words[floor]) > 0) {
            return floor;
        }
        else if (ceiling != words.length && midWord.compareTo(words[ceiling]) > 0) {
            return ceiling;
        }

        throw new RuntimeException("failed to find midpoint");
    }

}
