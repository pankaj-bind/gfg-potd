class Solution {
    static int singleElement(int[] arr, int N) {
        int result = 0;

        // Iterate through each bit position
        for (int i = 0; i < 32; i++) {
            int sum = 0; // Count of set bits at the current position

            // Count set bits for all elements
            for (int j = 0; j < N; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    sum++;
                }
            }

            // If the sum is not a multiple of 3, set the corresponding bit in the result
            if (sum % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }
}
