// User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int minPrice = Integer.MAX_VALUE; // Initialize to the highest possible value
        int maxProfit = 0; // Initialize to 0 as no profit is possible initially
        
        // Iterate through the price array
        for (int price : prices) {
            if (price < minPrice) {
                // Update minimum price
                minPrice = price;
            } else {
                // Calculate potential profit and update maxProfit
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        
        return maxProfit;
    }
}
