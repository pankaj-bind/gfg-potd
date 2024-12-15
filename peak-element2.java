class Solution {

    public int peakElement(int[] arr) {
        int n = arr.length;
        
        // Handle edge cases for arrays of size 1
        if (n == 1) return 0;
        
        // Binary Search Approach for O(log n) time complexity
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is a peak element
            if ((mid == 0 || arr[mid] > arr[mid - 1]) &&
                (mid == n - 1 || arr[mid] > arr[mid + 1])) {
                return mid;
            }

            // If the left neighbor is greater, move to the left half
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            } else {
                // Otherwise, move to the right half
                low = mid + 1;
            }
        }

        // Should never reach here if input is valid
        return -1;
    }
}
