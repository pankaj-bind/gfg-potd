class Solution {
    public static int findWinner(int n, int x, int y) {
        // Create a dp array of size n+1
        boolean[] dp = new boolean[n + 1];

        // Base case
        dp[0] = false; // No coins left means Geek loses

        // Fill dp array using the recurrence relation
        for (int i = 1; i <= n; i++) {
            // Check if picking 1, x or y coins leaves the opponent in a losing state
            if (i >= 1 && !dp[i - 1]) {
                dp[i] = true;
            } else if (i >= x && !dp[i - x]) {
                dp[i] = true;
            } else if (i >= y && !dp[i - y]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        // Return 1 if Geek wins with n coins, else 0
        return dp[n] ? 1 : 0;
    }
}
