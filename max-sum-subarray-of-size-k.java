class Solution {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        // code here
        long maxSum = 0;
        long currentSum = 0;

        // Calculate sum of the first K elements
        for (int i = 0; i < K; i++) {
            currentSum += Arr.get(i);
        }

        maxSum = currentSum;

        // Iterate through the array using sliding window
        for (int i = K; i < N; i++) {
            // Include the current element in the window
            currentSum += Arr.get(i);

            // Exclude the leftmost element from the window
            currentSum -= Arr.get(i - K);

            // Update the maximum sum if the current sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}