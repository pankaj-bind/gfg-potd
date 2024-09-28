// User function Template for Java

class Solution {
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;  // starting point, no cost
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + k && j < n; j++) {
                dp[j] = Math.min(dp[j], dp[i] + Math.abs(arr[i] - arr[j]));
            }
        }
        
        return dp[n - 1];  // minimum cost to reach the last stone
    }
}
