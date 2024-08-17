class Solution {
    // Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z) {
        // Create a dp array of size n+1 initialized with -1
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // Base case: No cuts can be made on a segment of length 0
        dp[0] = 0;

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            // If a cut of length x is possible
            if (i >= x && dp[i - x] != -1) {
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }
            // If a cut of length y is possible
            if (i >= y && dp[i - y] != -1) {
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }
            // If a cut of length z is possible
            if (i >= z && dp[i - z] != -1) {
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
            }
        }

        // If no cuts are possible, return 0, otherwise return dp[n]
        return dp[n] == -1 ? 0 : dp[n];
    }
}
