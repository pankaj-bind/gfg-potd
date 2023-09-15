class Solution
{
    // Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        final int MOD = 1000000007;
        
        // Create an array to store the number of ways to reach each step.
        long[] dp = new long[n + 1];
        
        // Base cases: There is 1 way to reach the 0th step (by not moving).
        dp[0] = 1;
        
        // Loop through each step from 1 to n.
        for (int i = 1; i <= n; i++) {
            // At each step, the frog can take 1, 2, or 3 steps.
            // So, the total number of ways to reach step i is the sum of
            // the number of ways to reach the previous three steps.
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
                }
            }
        }
        
        return dp[n];
    }
}
