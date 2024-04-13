class Solution {
    static Long reversedBits(Long x) {
        long result = 0;
        int bitPosition = 31; // since we're dealing with 32-bit integers
        while (x != 0) {
            // Check if the rightmost bit of x is set
            if ((x & 1) == 1) {
                // If set, set the corresponding bit in result
                result |= (1L << bitPosition);
            }
            // Right shift x to move to the next bit
            x >>= 1;
            bitPosition--; // Move to the next bit position in result
        }
        return result;
    }
}
