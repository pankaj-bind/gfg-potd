class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
        int MOD = 1000000007;
        int sumArr = 0;
        for (int num : arr) {
            sumArr += num;
        }

        if ((sumArr + d) % 2 != 0 || sumArr < d) {
            return 0;
        }

        int target = (sumArr + d) / 2;

        int[] dp = new int[target + 1];
        dp[0] = 1; // There's one way to make sum 0, by choosing no elements

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % MOD;
            }
        }

        return dp[target];
    }
}
