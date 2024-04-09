class Solution {
    public int minPoints(int points[][], int m, int n) {
        // Initialize dp array
        int[][] dp = new int[m][n];
        
        // Initialize the destination cell
        dp[m-1][n-1] = Math.max(1, 1 - points[m-1][n-1]);
        
        // Iterate from bottom-right to top-left
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                // If it's the destination cell, skip
                if (i == m-1 && j == n-1) continue;
                
                // Calculate the minimum points needed at this cell
                int minPoints = Integer.MAX_VALUE;
                if (i + 1 < m) minPoints = Math.min(minPoints, dp[i+1][j]);
                if (j + 1 < n) minPoints = Math.min(minPoints, dp[i][j+1]);
                dp[i][j] = Math.max(1, minPoints - points[i][j]);
            }
        }
        
        // Return the minimum initial points needed
        return dp[0][0];
    }
}
