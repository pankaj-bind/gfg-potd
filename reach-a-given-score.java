class Geeks {
    public long count(int n) {
        // Create an array to store the number of ways to reach each score from 0 to n
        long[] dp = new long[n + 1];

        // Base case: There is 1 way to reach score 0 (no moves)
        dp[0] = 1;

        // Iterate through scores from 3 to n
        for (int i = 3; i <= n; i++) {
            // Update the number of ways to reach the current score using moves of 3, 5, and 10
            dp[i] += dp[i - 3];
        }

        for (int i = 5; i <= n; i++) {
            dp[i] += dp[i - 5];
        }

        for (int i = 10; i <= n; i++) {
            dp[i] += dp[i - 10];
        }

        // The final answer is stored in dp[n]
        return dp[n];
    }
}