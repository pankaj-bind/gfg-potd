class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // Sort the stalls array to make binary search feasible
        Arrays.sort(stalls);

        // Define the search range for the maximum minimum distance
        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Midpoint distance to check

            if (canPlaceCows(stalls, k, mid)) {
                result = mid; // Update result if this distance is feasible
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Try for a smaller minimum distance
            }
        }

        return result;
    }

    // Helper method to check if we can place k cows with at least `distance` between them
    private static boolean canPlaceCows(int[] stalls, int k, int distance) {
        int count = 1; // Place the first cow in the first stall
        int lastPosition = stalls[0]; // Position of the last placed cow

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++;
                lastPosition = stalls[i]; // Update the last placed position

                if (count == k) {
                    return true; // Successfully placed all cows
                }
            }
        }

        return false; // Not possible to place all cows with the given distance
    }
}
