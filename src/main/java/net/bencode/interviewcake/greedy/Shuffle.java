package net.bencode.interviewcake.greedy;

import java.util.Random;

public class Shuffle {

    private static Random rand = new Random();

    private static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }

    public static void shuffle(int[] array) {

        // shuffle the input in place
        for (int i = 0; i < array.length; i++) {
            int randomIndex = getRandom(i, array.length - 1);
            int tmp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = tmp;
        }
    }
}
