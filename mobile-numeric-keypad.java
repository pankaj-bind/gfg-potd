class Solution {
    public long getCount(int n) {
        if (n == 1) return 10; // For n=1, there are 10 possible sequences (0-9)

        // Define movements
        int[][] moves = {
            {8, 0},        // moves for 0
            {1, 2, 4},     // moves for 1
            {1, 2, 3, 5},  // moves for 2
            {2, 3, 6},     // moves for 3
            {1, 4, 5, 7},  // moves for 4
            {2, 4, 5, 6, 8}, // moves for 5
            {3, 5, 6, 9},  // moves for 6
            {4, 7, 8},     // moves for 7
            {5, 7, 8, 9, 0}, // moves for 8
            {6, 8, 9}      // moves for 9
        };

        // Initialize dp table
        long[][] dp = new long[n + 1][10];
        
        // Base case: For sequences of length 1, each digit is a valid sequence
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // Fill dp table
        for (int len = 2; len <= n; len++) {
            for (int digit = 0; digit < 10; digit++) {
                dp[len][digit] = 0;
                for (int move : moves[digit]) {
                    dp[len][digit] += dp[len - 1][move];
                }
            }
        }

        // Sum up the valid sequences of length n
        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[n][i];
        }

        return result;
    }
}
