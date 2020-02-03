package net.bencode.interviewcake.greedy;

public class AppleStocks {

    public static int getMaxProfit(int[] stockPrices) {

        // calculate the max profit

        if (stockPrices.length <= 1) {
            throw new RuntimeException("No or single stock price provided, nothing to compare");
        }

        // prime loop
        int maxProfit = stockPrices[1] - stockPrices[0];
        int lowestPrice = stockPrices[0];

        for (int i = 1; i < stockPrices.length; i++) {

            int currentPrice = stockPrices[i];

            // calculate maxProfit
            if (currentPrice - lowestPrice > maxProfit) {
                maxProfit = currentPrice - lowestPrice;
            }

            // track the lowest price seen (greedy)
            if (currentPrice < lowestPrice) {
                lowestPrice = currentPrice;
            }

        }

        return maxProfit;
    }
}
