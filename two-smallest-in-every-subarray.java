class Solution {
    public int pairWithMaxSum(int[] arr) {
        // If the array has less than 2 elements, return -1
        if (arr.length < 2) {
            return -1;
        }

        // Initialize maxSum to a very small value
        int maxSum = Integer.MIN_VALUE;

        // Loop through the array and calculate the sum of adjacent elements
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = arr[i] + arr[i + 1]; // Calculate the sum of adjacent elements
            maxSum = Math.max(maxSum, sum); // Update maxSum if the current sum is larger
        }

        return maxSum;
    }
}
