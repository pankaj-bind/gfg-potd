class Solution {
    // function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {
        int binary = n; // Start with the most significant bit same as n
        int mask = n >> 1; // Initialize mask to the next bit of n

        // Loop through all the bits starting from the second bit
        while (mask != 0) {
            binary = binary ^ mask; // XOR the current bit of Gray code with the previous bit of the binary representation
            mask = mask >> 1; // Move mask to the next bit
        }

        return binary; // Return the binary equivalent
    }
}