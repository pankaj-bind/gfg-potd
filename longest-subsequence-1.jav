class Solution {
    public static int longestSubseq(int n, int[] a) {
        // Create a dp array where dp[i] will store the length of the longest subsequence ending at i
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initialize all dp values to 1

        // Iterate over each element to build the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(a[i] - a[j]) == 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Find the maximum value in the dp array
        int maxLength = 0;
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
