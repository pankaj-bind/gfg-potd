class Solution {
    public int smallestSubstring(String S) {
        int n = S.length();

        // Initialize counts of 0, 1, and 2
        int count0 = 0, count1 = 0, count2 = 0;

        // Initialize left and right pointers
        int left = 0, right = 0;

        // Initialize the result
        int minLength = Integer.MAX_VALUE;

        while (right < n) {
            // Expand the window to the right
            char currentChar = S.charAt(right);
            if (currentChar == '0') {
                count0++;
            } else if (currentChar == '1') {
                count1++;
            } else {
                count2++;
            }

            // Check if the current window contains all three characters
            while (count0 > 0 && count1 > 0 && count2 > 0) {
                // Update the result
                int currentLength = right - left + 1;
                minLength = Math.min(minLength, currentLength);

                // Contract the window from the left
                char leftChar = S.charAt(left);
                if (leftChar == '0') {
                    count0--;
                } else if (leftChar == '1') {
                    count1--;
                } else {
                    count2--;
                }

                left++;
            }

            // Move the right pointer to expand the window
            right++;
        }

        // If minLength is still Integer.MAX_VALUE, no valid substring was found
        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
    }
}