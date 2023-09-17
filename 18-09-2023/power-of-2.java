class Solution {
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        // If n is less than or equal to zero, it can't be a power of 2
        if (n <= 0) {
            return false;
        }
        
        // Use bitwise AND operation to check if there is only one set bit
        return (n & (n - 1)) == 0;
    }
}
