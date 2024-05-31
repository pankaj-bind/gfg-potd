class Solution {
    static int swapNibbles(int n) {
        // Shift the lower nibble (rightmost 4 bits) to the left by 4 positions
        int leftNibbleShifted = (n & 0x0F) << 4;
        // Shift the higher nibble (leftmost 4 bits) to the right by 4 positions
        int rightNibbleShifted = (n & 0xF0) >> 4;
        // Combine the shifted nibbles using bitwise OR
        return leftNibbleShifted | rightNibbleShifted;
    }
}
