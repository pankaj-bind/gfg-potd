class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr[i];
        }
        
        // If sum is odd, it's not possible to divide into two equal partitions
        if(sum % 2 != 0) return 0;
        
        // Calculate half of the sum
        int targetSum = sum / 2;
        
        // Initialize a DP array to store the results
        boolean dp[][] = new boolean[N + 1][targetSum + 1];
        
        // Base case: If targetSum is 0, it's always possible to form an empty subset
        for(int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
        
        // DP iteration
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= targetSum; j++) {
                // If current element is greater than target sum, exclude it
                if(arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Otherwise, consider either excluding or including the element
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        
        // The answer will be in the bottom-right cell of the DP table
        return dp[N][targetSum] ? 1 : 0;
    }
}
