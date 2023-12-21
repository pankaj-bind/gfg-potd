class Solution {
    static int minCandy(int N, int ratings[]) {
        // code here
        if (N == 0) {
            return 0;
        }

        int[] candies = new int[N];
        Arrays.fill(candies, 1); // Initially, assign 1 candy to each child

        // Traverse from left to right to satisfy the increasing rating condition
        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Traverse from right to left to satisfy the decreasing rating condition
        for (int i = N - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate the total number of candies needed
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}