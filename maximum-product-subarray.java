class Solution {
    // Function to find the maximum product subarray
    int maxProduct(int[] arr) {
        // Base case: if the array has only one element
        if (arr.length == 0) return 0;

        // Initialize variables to track the maximum, minimum, and global maximum product
        int maxProduct = arr[0]; // The result
        int currentMax = arr[0]; // Current maximum product up to this position
        int currentMin = arr[0]; // Current minimum product up to this position

        // Traverse the array from the second element
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];

            // If the current number is negative, swap currentMax and currentMin
            if (num < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            // Update the current maximum and minimum products
            currentMax = Math.max(num, currentMax * num);
            currentMin = Math.min(num, currentMin * num);

            // Update the global maximum product
            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }
}
