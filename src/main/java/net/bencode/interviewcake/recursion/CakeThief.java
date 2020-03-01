package net.bencode.interviewcake.recursion;

public class CakeThief {



    public static class CakeType {

        final int weight;
        final int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value  = value;
        }
    }

    public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {

        // calculate the maximum value that we can carry

        int[] maxValuesAtCapacity = new int[weightCapacity + 1];
        maxValuesAtCapacity[0] = 0;

        for (int duffelSize = 1; duffelSize <= weightCapacity; duffelSize++) {

            for (CakeType cake : cakeTypes) {

                if (cake.weight == duffelSize) { //ex: 3kg cake for 3kg duffel
                    maxValuesAtCapacity[duffelSize] = Math.max(cake.value, maxValuesAtCapacity[duffelSize]);
                }
                else if (cake.weight < duffelSize) { //ex: 1 or 2kg cake for 3kg duffel
                    int remainingDuffelSpace = duffelSize - cake.weight;
                    int currentValue = cake.value + maxValuesAtCapacity[remainingDuffelSpace];
                    maxValuesAtCapacity[duffelSize] = Math.max(currentValue, maxValuesAtCapacity[duffelSize]);
                }

            }

        }




        return maxValuesAtCapacity[weightCapacity];
    }


}
