class Solution
{
    public int firstElementKTime(int n, int k, int[] a) {
        // HashMap to store the count of each element
        Map<Integer, Integer> countMap = new HashMap<>();

        // Iterate through the array to count occurrences
        for (int i = 0; i < n; i++) {
            int current = a[i];

            // Update the count for the current element
            countMap.put(current, countMap.getOrDefault(current, 0) + 1);

            // Check if the current element occurs at least k times
            if (countMap.get(current) == k) {
                return current; // Return the first element that satisfies the condition
            }
        }

        return -1; // If no element occurs at least k times
    }
}