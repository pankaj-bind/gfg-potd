class Solution {
    public int myAtoi(String s) {
        // Define the bounds for a 32-bit signed integer
        int INT_MAX = Integer.MAX_VALUE; 
        int INT_MIN = Integer.MIN_VALUE;
        
        int i = 0, n = s.length();
        
        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check for sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // Step 3: Read the digits and ignore non-digit characters
        long result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            i++;

            // Step 4: Check for overflow
            if (result * sign > INT_MAX) {
                return INT_MAX;
            }
            if (result * sign < INT_MIN) {
                return INT_MIN;
            }
        }

        // Step 5: Return the final result
        return (int) (result * sign);
    }
}
