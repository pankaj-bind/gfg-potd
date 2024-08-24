class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        int N = wt.length;
        // dp[i][j] will store the maximum value that can be achieved with the first i items and capacity j
        int[][] dp = new int[N + 1][W + 1];

        // Build the dp array in bottom-up manner
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                // If the weight of the item is more than the current capacity, skip the item
                if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Otherwise, choose the maximum value between including the item or not
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }
        }

        // The result is stored in dp[N][W]
        return dp[N][W];
    }
}
