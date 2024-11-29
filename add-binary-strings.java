class Solution {
    public String addBinary(String s1, String s2) {
        int i = s1.length() - 1; // Pointer for s1
        int j = s2.length() - 1; // Pointer for s2
        int carry = 0; // Carry bit
        StringBuilder result = new StringBuilder(); // To store the resultant binary string

        // Loop until all bits and carry are processed
        while (i >= 0 || j >= 0 || carry > 0) {
            int bit1 = (i >= 0) ? s1.charAt(i) - '0' : 0; // Get bit from s1 or 0 if exhausted
            int bit2 = (j >= 0) ? s2.charAt(j) - '0' : 0; // Get bit from s2 or 0 if exhausted
            int sum = bit1 + bit2 + carry; // Calculate sum of bits and carry
            result.append(sum % 2); // Append the resulting bit (0 or 1)
            carry = sum / 2; // Calculate new carry
            i--; // Move to the next bit in s1
            j--; // Move to the next bit in s2
        }

        // Since the bits are appended in reverse order, reverse the result to get the final string
        result.reverse();

        // Remove leading zeros (if any) and return the final result
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}
