class Solution {
    public int findMinCost(String x, String y, int costX, int costY) {
        int m = x.length();
        int n = y.length();
        
        // Create a DP table with dimensions (m+1) x (n+1)
        int[][] dp = new int[m+1][n+1];
        
        // Initialize base cases
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i * costX;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j * costY;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];  // Characters match, no additional cost
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + costX, dp[i][j-1] + costY);  // Characters do not match, take minimum of deleting from x or y
                }
            }
        }
        
        // The answer is in dp[m][n]
        return dp[m][n];
    }
}
