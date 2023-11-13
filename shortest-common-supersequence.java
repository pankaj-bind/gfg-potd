class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X, String Y, int m, int n)
    {
        // Create a 2D array to store the length of the shortest common supersequence.
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array using bottom-up dynamic programming.
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the shortest common supersequence is the sum of lengths
        // of X and Y minus the length of their longest common subsequence.
        int lcsLength = dp[m][n];
        int scsLength = m + n - lcsLength;

        return scsLength;
    }
}
