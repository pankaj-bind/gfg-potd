class Solution {
    public static int pairsum(int[] arr) {
        // Initialize two largest variables
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                // Update second to first, and first to current element
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                // Update second if current element is greater than second
                second = arr[i];
            }
        }

        // Return the sum of the two largest elements
        return first + second;
    }
}
