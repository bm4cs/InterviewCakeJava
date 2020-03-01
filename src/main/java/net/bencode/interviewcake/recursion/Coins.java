package net.bencode.interviewcake.recursion;

import java.util.Arrays;

public class Coins {

    public static int changePossibilities(int amount, int[] denominations) {

        // calculate the number of ways to make change


        return changePossibilitiesTopDown(amount, denominations, 0);
    }



    private static int changePossibilitiesTopDown(int amountLeft, int[] denominations, int index) {

        if (amountLeft == 0) {
            return 1;
        }

        if (amountLeft < 0) {
            return 0;
        }

        if (index == denominations.length) {
            return 0;
        }

        System.out.printf("checking ways to make %d with %s\n",
                amountLeft,
                Arrays.toString(Arrays.copyOfRange(denominations, index, denominations.length)));

        int currentCoin = denominations[index];
        int numPossibilities = 0;

        while (amountLeft >= 0) {

//            System.out.printf("  looping start coin %d possibilities %d amountLeft %d\n",
//                    currentCoin,
//                    numPossibilities,
//                    amountLeft);

            numPossibilities += changePossibilitiesTopDown(amountLeft, denominations, index + 1);

//            System.out.printf("  looping end coin %d possibilities %d amountLeft %d\n",
//                    currentCoin,
//                    numPossibilities,
//                    amountLeft);

            amountLeft -= currentCoin;
        }

        return numPossibilities;
    }


}
