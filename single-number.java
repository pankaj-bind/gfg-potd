class Solution {
    int getSingle(int arr[]) {
        // Initialize a variable to store the XOR of all elements
        int result = 0;
        
        // XOR all elements of the array
        for (int num : arr) {
            result ^= num;
        }
        
        // The result will hold the number that appears an odd number of times
        return result;
    }
}
