package net.bencode.interviewcake.greedy;

public class ProductOfOtherNumbers {

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        if (intArray == null || intArray.length < 2) {
            throw new RuntimeException("dodgy input provided");
        }

        // [1, 7, 3, 4] becomes [84, 12, 28, 21]

        // Rules: no division allowed, O(n) time, support negatives
        // the are cached products
        // the index into the table represents the total products before and after
        int[] productsIfAllExceptAtIndexArray = new int[intArray.length];
        int[] beforeProductsArray = new int[intArray.length];
        int[] afterProductsArray = new int[intArray.length];
        beforeProductsArray[0] = 1;
        afterProductsArray[0] = 1;

        // step 1 store the total of products based on current index
        // providing a convenient index based lookup
        for (int i = 1; i < intArray.length; i++) {
            beforeProductsArray[i] = intArray[i - 1] * beforeProductsArray[i - 1];

            int endIndex = (intArray.length - 1) - i;
            afterProductsArray[i] = intArray[endIndex + 1] * afterProductsArray[i - 1];
        }

        for (int i = 0; i < intArray.length; i++) {
            productsIfAllExceptAtIndexArray[i] = beforeProductsArray[i] * afterProductsArray[(intArray.length - 1) - i];
        }

        // time: two loops through n = O(2n) = O(n)
        // space: O(3n) = O(n)

        return productsIfAllExceptAtIndexArray;
    }
}
