class solve {
    static long countMaximum(int n, int arr[]) {
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return maxAmount(arr, 0, n - 1, dp);
    }

    static long maxAmount(int[] arr, int left, int right, long[][] dp) {
        if (left > right)
            return 0;
        if (left == right)
            return arr[left];
        if (dp[left][right] != -1)
            return dp[left][right];
        long selectLeft = arr[left] + Math.min(maxAmount(arr, left + 2, right, dp),
                maxAmount(arr, left + 1, right - 1, dp));
        long selectRight = arr[right] + Math.min(maxAmount(arr, left + 1, right - 1, dp),
                maxAmount(arr, left, right - 2, dp));
        dp[left][right] = Math.max(selectLeft, selectRight);
        return dp[left][right];
    }
}
