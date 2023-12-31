class Solution {
    public static boolean solve(int n, int coins[], int[][] dp, int i, int sum) {
        if (i == n) {
            if ((sum % 20 == 0 || sum % 24 == 0 || sum == 2024) && sum != 0) {
                return true;
            }
            return false;
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }

        boolean include = solve(n, coins, dp, i + 1, coins[i] + sum);
        boolean exclude = solve(n, coins, dp, i + 1, sum);

        dp[i][sum] = (include || exclude) ? 1 : 0;
        return include || exclude;
    }

    public static boolean isPossible(int N, int coins[]) {
        int[][] dp = new int[N + 1][2025];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(N, coins, dp, 0, 0);
    }
}