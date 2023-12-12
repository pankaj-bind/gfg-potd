class Solution {
    static int maxGold(int n, int m, int M[][]) {
        // dp array to store maximum gold
        int dp[][] = new int[n][m];

        // Initialize dp array with the values of the last column
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = M[i][m - 1];
        }

        // Traverse the mine from right to left
        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                // Three possible moves: diagonal up, right, diagonal down
                int moveUp = (i > 0) ? dp[i - 1][j + 1] : 0;
                int moveRight = dp[i][j + 1];
                int moveDown = (i < n - 1) ? dp[i + 1][j + 1] : 0;

                // Update dp array with the maximum value
                dp[i][j] = M[i][j] + Math.max(moveUp, Math.max(moveRight, moveDown));
            }
        }

        // Find the maximum value in the first column of dp array
        int maxGold = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        return maxGold;
    }
}
