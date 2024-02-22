class Solution
{
    int mod = 1000000007;

    int subsequenceCount(String s, String t)
    {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[m + 1][n + 1];

        // Initialize the first row with 1, as an empty string is a subsequence of any string.
        for (int j = 0; j <= n; j++)
            dp[0][j] = 1;

        // Fill the dp matrix using the recurrence relation.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];

                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
            }
        }

        return dp[m][n];
    }
}
