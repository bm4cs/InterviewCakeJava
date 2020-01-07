package net.bencode.interviewcake.arraysandstrings;

public class CafeOrderChecker {

    public static boolean checkFifo(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {

        int currentTakeOutIndex = 0;
        int currentDineInIndex = 0;

        if (takeOutOrders.length + dineInOrders.length > servedOrders.length) {
            throw new RuntimeException("Some orders were not processed");
        }

        if (servedOrders.length > takeOutOrders.length + dineInOrders.length) {
            throw new RuntimeException("Orders made that were not paid for");
        }

        for (int order : servedOrders) {

            if (currentDineInIndex < dineInOrders.length && order == dineInOrders[currentDineInIndex]) {
                currentDineInIndex++;
            }
            else if (currentTakeOutIndex < takeOutOrders.length && order == takeOutOrders[currentTakeOutIndex]) {
                currentTakeOutIndex++;
            }
            else {
                return false;
            }
        }

        return true;
    }
}
