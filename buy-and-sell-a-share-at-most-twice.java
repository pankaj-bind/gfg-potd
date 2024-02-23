class Solution {
    public static int maxProfit(int n, int[] price) {
        if (n <= 1) {
            return 0;
        }

        int[] profit1 = new int[n]; // max profit with at most one transaction
        int[] profit2 = new int[n]; // max profit with at most two transactions

        int minPrice = price[0];

        // Calculate profit1 for each day
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, price[i]);
            profit1[i] = Math.max(profit1[i - 1], price[i] - minPrice);
        }

        int maxPrice = price[n - 1];

        // Calculate profit2 for each day
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, price[i]);
            profit2[i] = Math.max(profit2[i + 1], maxPrice - price[i]);
        }

        int maxProfit = 0;

        // Calculate the maximum profit with at most two transactions
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, profit1[i] + (i + 1 < n ? profit2[i + 1] : 0));
        }

        return maxProfit;
    }
}
