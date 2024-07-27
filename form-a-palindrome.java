class Solution{
    static int countMin(String str)
    {
        int n = str.length();
        int[][] dp = new int[n][n];
        
        for (int length = 1; length < n; length++) {
            for (int i = 0; i < n - length; i++) {
                int j = i + length;
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j]) + 1;
                }
            }
        }
        
        return dp[0][n-1];
    }
}
