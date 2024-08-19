// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1); // K-1 because array index starts from 0
    }

    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low]; // Only one element
        }

        int pivotIndex = partition(arr, low, high);

        // If pivotIndex is the Kth element
        if (pivotIndex == k) {
            return arr[pivotIndex];
        } else if (pivotIndex > k) {
            // Go left
            return quickSelect(arr, low, pivotIndex - 1, k);
        } else {
            // Go right
            return quickSelect(arr, pivotIndex + 1, high, k);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        // Swap arr[i] and arr[high] (pivot)
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i; // Return the position of pivot
    }
}
