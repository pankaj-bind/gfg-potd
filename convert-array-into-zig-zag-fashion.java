// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        char[] binary = s.toCharArray();
        int n = binary.length;

        // Traverse from end to start
        for (int i = n - 1; i >= 0; i--) {
            if (binary[i] == '0') {
                binary[i] = '1'; // Change '0' to '1'
                // Set all bits after i to '0'
                for (int j = i + 1; j < n; j++) {
                    binary[j] = '0';
                }
                return new String(binary);
            }
        }

        // If no '0' is found, the number is all '1's
        StringBuilder result = new StringBuilder();
        result.append('1'); // Prepend '1'
        for (int i = 0; i < n; i++) {
            result.append('0'); // Append '0's
        }
        return result.toString();
    }
}
