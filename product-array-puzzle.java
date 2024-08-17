class Solution {
    public static long[] productExceptSelf(int nums[]) {
        int n = nums.length;
        long[] result = new long[n];
        long[] left = new long[n];
        long[] right = new long[n];

        // Initialize left array
        left[0] = 1;  // There is no element to the left of the first element
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // Initialize right array
        right[n - 1] = 1;  // There is no element to the right of the last element
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Construct the result array
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}
