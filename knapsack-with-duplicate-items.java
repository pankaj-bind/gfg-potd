class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[] dp = new int[W + 1];
        dp[0] = 0; // Initialize dp array with zeros
        
        for (int i = 1; i <= W; i++) {
            for (int j = 0; j < N; j++) {
                if (wt[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        
        return dp[W];
    }
}
