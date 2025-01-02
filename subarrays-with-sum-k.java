// User function Template for Java
class Solution {
    public int countSubarrays(int arr[], int k) {
        // HashMap to store prefix sum frequencies
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Initialize variables
        int count = 0;
        int currentSum = 0;
        
        // Add base case: prefix sum 0 occurs once (empty prefix)
        prefixSumMap.put(0, 1);

        // Iterate through the array
        for (int num : arr) {
            // Update current sum
            currentSum += num;

            // Check if there exists a prefix sum that satisfies the condition
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }

            // Update the prefix sum map
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
