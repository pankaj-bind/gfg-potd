class Solution {
    public int wildCard(String pattern, String str) {
        int m = pattern.length();
        int n = str.length();

        // DP table where dp[i][j] means if first i chars of pattern matches first j chars of str
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base cases
        dp[0][0] = true;  // Empty pattern matches empty string

        // Fill first row (when pattern matches empty string)
        for (int i = 1; i <= m; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];  // '*' can match empty sequence
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pattern.charAt(i - 1) == '*') {
                    // '*' matches with empty sequence (dp[i-1][j]) or it matches with one or more characters (dp[i][j-1])
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (pattern.charAt(i - 1) == '?' || pattern.charAt(i - 1) == str.charAt(j - 1)) {
                    // '?' or exact character match
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Characters don't match
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n] ? 1 : 0;
    }
}

