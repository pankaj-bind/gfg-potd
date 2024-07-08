class Solution {
    int search(int[] arr, int key) {
        int n = arr.length;
        int low = 0, high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // If the key is found at mid, return the index
            if (arr[mid] == key) {
                return mid;
            }
            
            // Determine if the left half is sorted
            if (arr[low] <= arr[mid]) {
                // Check if the key is within the range of the sorted left half
                if (arr[low] <= key && key < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                // Check if the key is within the range of the sorted right half
                if (arr[mid] < key && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        // If the key was not found, return -1
        return -1;
    }
}
