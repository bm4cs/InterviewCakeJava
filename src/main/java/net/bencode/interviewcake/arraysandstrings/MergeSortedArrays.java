package net.bencode.interviewcake.arraysandstrings;

public class MergeSortedArrays {

    public static int[] mergeArrays(int[] arrayA, int[] arrayB) {

        int indexA = 0, indexB = 0, indexMerged = 0;
        int[] mergedArray = new int[arrayA.length + arrayB.length];

        while (indexA != arrayA.length || indexB != arrayB.length) {

            if (indexA == arrayA.length) {
                mergedArray[indexMerged] = arrayB[indexB++];
            }
            else if (indexB == arrayB.length) {
                mergedArray[indexMerged] = arrayA[indexA++];
            }
            else if (arrayA[indexA] <= arrayB[indexB]) {
                mergedArray[indexMerged] = arrayA[indexA++];
            }
            else {
                mergedArray[indexMerged] = arrayB[indexB++];
            }

            indexMerged++;
        }

        return mergedArray;
    }


    public static int[] mergeArraysCombinationalLogic(int[] arrayA, int[] arrayB) {

        int indexA = 0, indexB = 0, indexMerged = 0;
        int[] mergedArray = new int[arrayA.length + arrayB.length];

        while (indexA != arrayA.length || indexB != arrayB.length) {

            boolean isAExhausted = indexA >= arrayA.length;
            boolean isBExhausted = indexB >= arrayB.length;

            if (!isAExhausted &&
                    (isBExhausted || (arrayA[indexA] <= arrayB[indexB]))) {
                mergedArray[indexMerged] = arrayA[indexA++];
            }
            else {
                mergedArray[indexMerged] = arrayB[indexB++];
            }

            indexMerged++;
        }

        return mergedArray;
    }
}
