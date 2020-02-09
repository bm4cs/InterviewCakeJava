package net.bencode.interviewcake.greedy;

public class HighestProductOfThree {

    public static int highestProductOf3(int[] intArray) {

        if (intArray.length < 3) {
            throw new RuntimeException("Not enough inputs provided");
        }

        // 1, 2, 3, 4
        // = 24


        // Divide & conquer:
        // within each iteration to compute highest product of 3,
        // requires you know the highest (or lowest for negatives) product of 2,
        // which in turn to compute requires you know the highest or lowest integer.
        // a greedy algorithm can do in in O(n) time and O(1) space
        int highestProductOf3 = intArray[0] * intArray[1] * intArray[2];

        int highestProductOf2 = intArray[0] * intArray[1];
        int lowestProductOf2 = intArray[0] * intArray[1];

        int lowest = Math.min(intArray[0], intArray[1]);
        int highest = Math.max(intArray[0], intArray[1]);

        for (int i = 2; i < intArray.length; i++) {

            int current = intArray[i];

            highestProductOf3 = Math.max(
                    Math.max(highestProductOf2 * current, lowestProductOf2 * current),
                    highestProductOf3);

            highestProductOf2 = Math.max(
                    Math.max(current * highest, current * lowest),
                    highestProductOf2);

            lowestProductOf2 = Math.min(
                    Math.min(current * lowest, current * highest),
                    lowestProductOf2);

            highest = Math.max(current, highest);
            lowest = Math.min(current, lowest);
        }

        return highestProductOf3;
    }


}
