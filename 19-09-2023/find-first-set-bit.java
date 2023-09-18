class Solution
{
    // Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
        // If n is 0, there are no set bits.
        if (n == 0)
            return 0;
        
        // Finding the rightmost set bit position using bitwise AND
        int position = 1;
        int mask = 1;
        while ((n & mask) == 0) {
            position++;
            mask = mask << 1;
        }
        
        return position;
    }
}
