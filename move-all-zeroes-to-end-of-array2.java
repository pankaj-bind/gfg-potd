// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int nonZeroIndex = 0; // Pointer for the next position to place a non-zero element

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // If the current element is non-zero, swap it with the element at nonZeroIndex
            if (arr[i] != 0) {
                int temp = arr[nonZeroIndex];
                arr[nonZeroIndex] = arr[i];
                arr[i] = temp;

                // Move the nonZeroIndex forward
                nonZeroIndex++;
            }
        }
    }
}
