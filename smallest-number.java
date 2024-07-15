class Solution {
    public String smallestNumber(int s, int d) {
        // If the sum of digits s is greater than the maximum possible sum with d digits
        if (s > 9 * d) {
            return "-1";
        }
        
        // Create an array to store digits of the result number
        int[] result = new int[d];
        
        // Start from the last digit and move to the first
        for (int i = d - 1; i >= 0; i--) {
            // If the remaining sum is greater than 9, place 9 at the current position
            if (s > 9) {
                result[i] = 9;
                s -= 9;
            } else {
                // Otherwise, place the remaining sum at the current position
                result[i] = s;
                s = 0;
            }
        }
        
        // Ensure the first digit is not zero
        if (result[0] == 0) {
            result[0] = 1;
            for (int i = 1; i < d; i++) {
                if (result[i] > 0) {
                    result[i]--;
                    break;
                }
            }
        }
        
        // Convert the result array to a string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d; i++) {
            sb.append(result[i]);
        }
        
        return sb.toString();
    }
}
