class Solution {
    public int minOperations(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        // Create a DP table to store lengths of longest common subsequence
        int[][] dp = new int[m + 1][n + 1];
        
        // Build the dp array in bottom-up fashion
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // LCS length is found in dp[m][n]
        int lcsLength = dp[m][n];
        
        // Calculate minimum operations
        int deletions = m - lcsLength;
        int insertions = n - lcsLength;
        
        // Return the sum of deletions and insertions
        return deletions + insertions;
    }
}
