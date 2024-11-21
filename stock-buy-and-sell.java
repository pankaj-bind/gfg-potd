class Solution {
    public int maximumProfit(int prices[]) {
        int n = prices.length;
        int profit = 0;

        // Traverse the price array
        for (int i = 1; i < n; i++) {
            // If the current price is greater than the previous price, we can make a profit
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }
}
