class Solution {
    static long sumMatrix(long n, long q) {
        // If q is outside the range of possible values in the matrix
        if (q < 2 || q > 2 * n) {
            return 0;
        }
        
        // Calculate the valid range of i and j
        long start = Math.max(1, q - n);
        long end = Math.min(n, q - 1);
        
        // The count of valid pairs (i, j) is the range length
        return end - start + 1;
    }
}
