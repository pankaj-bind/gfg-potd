class Solution {
    public int kthMissing(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        // Binary search to find the position where the kth missing number would fit
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Missing numbers till arr[mid]
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                left = mid + 1; // Look to the right
            } else {
                right = mid - 1; // Look to the left
            }
        }

        // Calculate the kth missing number
        return left + k;
    }
}
