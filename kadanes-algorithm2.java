// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        // Initialize variables
        int maxSoFar = Integer.MIN_VALUE; // Tracks the maximum sum found so far
        int maxEndingHere = 0;           // Tracks the maximum sum ending at the current position

        // Traverse the array
        for (int num : arr) {
            maxEndingHere += num;        // Include the current element in the subarray
            maxSoFar = Math.max(maxSoFar, maxEndingHere); // Update the max sum so far

            // If the current sum becomes negative, reset it to 0
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return maxSoFar; // Return the maximum sum of any subarray
    }
}
