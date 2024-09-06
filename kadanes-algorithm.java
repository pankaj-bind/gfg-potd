class Solution {

    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        
        // Initialize variables
        int max_so_far = arr[0];
        int current_max = arr[0];

        // Traverse through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {

            // Update the current maximum
            current_max = Math.max(arr[i], current_max + arr[i]);

            // Update the maximum so far
            max_so_far = Math.max(max_so_far, current_max);
        }

        return max_so_far;
    }
}
