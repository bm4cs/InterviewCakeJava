package net.bencode.interviewcake.hashing;

import java.util.Arrays;

public class TopScores {

    public static int[] sortScores(int[] unorderedScores, int highestPossibleScore) {

        if (unorderedScores.length <= 1) {
            return unorderedScores;
        }

        // sort the scores in O(n) time
        int[] orderedScores = new int[unorderedScores.length];
        int[] scoreCounts = new int[highestPossibleScore + 1];
        int orderedScoreIndex = 0;

        Arrays.fill(scoreCounts, 0);

        // keep a running total of each score - O(n) time
        for (int i : unorderedScores) {
            scoreCounts[i] = scoreCounts[i] + 1;
        }

        // work backwards through the running totals (highest to lowest)
        for (int testScore = scoreCounts.length - 1; testScore > 0; testScore--) {

            if (scoreCounts[testScore] > 0) {

                for (int i = 0; i < scoreCounts[testScore]; i++) {
                    orderedScores[orderedScoreIndex++] = testScore;
                }

            }

        }


        return orderedScores;
    }
}
