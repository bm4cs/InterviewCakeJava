package net.bencode.interviewcake.hashing;

import java.util.HashSet;

public class InflightEntertainment {


    // O(n) time, O(n) space
    public static boolean existsTwoMoviesEqualToFlightTime(int flightLength, int[] movieLengths) {

        HashSet<Integer> movieSet = new HashSet<>();

        for (int movieLength : movieLengths) {

            int movieBLength = flightLength - movieLength;

            if (movieSet.contains(movieBLength)) {
                return true;
            }

            movieSet.add(movieLength);
        }

        return false;
    }

}
