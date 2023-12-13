class Solution {
    long countStrings(int n) {
        // Initialize base cases
        long endingWithZero = 1;
        long endingWithOne = 1;

        // Iterate from length 2 to n
        for (int i = 2; i <= n; i++) {
            // Calculate new values based on recurrence relation
            long newEndingWithZero = (endingWithZero + endingWithOne) % 1000000007;
            long newEndingWithOne = endingWithZero % 1000000007;

            // Update values for the next iteration
            endingWithZero = newEndingWithZero;
            endingWithOne = newEndingWithOne;
        }

        // Return the sum of strings ending with 0 and 1
        return (endingWithZero + endingWithOne) % 1000000007;
    }
}