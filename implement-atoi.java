class Solution
{
    int atoi(String s) {
        // Your code here
        if (s == null || s.length() == 0) {
            return -1;
        }

        int result = 0;
        int i = 0;
        int n = s.length();
        boolean isNegative = false;

        // Check for negative sign
        if (s.charAt(0) == '-') {
            isNegative = true;
            i++;
        }

        // Iterate through the string and convert to integer
        while (i < n) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                int digit = currentChar - '0';

                // Check for overflow
                if (result > (Integer.MAX_VALUE - digit) / 10) {
                    return -1;
                }

                result = result * 10 + digit;
            } else {
                // If a non-digit character is encountered, return -1
                return -1;
            }

            i++;
        }

        // Apply the sign to the result
        return isNegative ? -result : result;
    }
}