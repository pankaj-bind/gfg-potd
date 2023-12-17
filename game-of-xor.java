class Solution {
    static int gameOfXor(int N , int[] A) {
        int result = 0;
        
        for (int i = 0; i < N; i++) {
            // Count the number of subarrays containing A[i]
            // Formula: (i + 1) * (N - i)
            int count = (i + 1) * (N - i);
            
            // If the count is odd, XOR the result with A[i]
            if (count % 2 == 1) {
                result ^= A[i];
            }
        }
        
        return result;
    }
}
