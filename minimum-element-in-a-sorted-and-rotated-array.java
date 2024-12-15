class Solution {
    public int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;

        // Handle the case where the array is not rotated
        if (arr[low] <= arr[high]) {
            return arr[low];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the mid element is the minimum
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }
            
            // Check if the next element is the minimum
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }

            // Decide which part to search
            if (arr[mid] >= arr[low]) {
                low = mid + 1; // Move to the unsorted part
            } else {
                high = mid - 1; // Move to the unsorted part
            }
        }

        return -1; // This case should never occur
    }
}
