class Solution {
    public static int countWays(String s1, String s2) {
        int MOD = 1_000_000_007;
        int n = s1.length();
        int m = s2.length();

        // Create a 2D dp array
        int[][] dp = new int[n + 1][m + 1];

        // Initialize dp[i][0] to 1 for all i (empty string s2)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Return the result
        return dp[n][m];
    }
}
