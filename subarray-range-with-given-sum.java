class Solution {
    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int tar) {
        // HashMap to store the frequency of prefix sums.
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Variable to keep track of the current prefix sum.
        int prefix_sum = 0;
        
        // This will store the count of subarrays that sum up to the target.
        int count = 0;
        
        // Initialize the map with the base case (prefix sum of 0 occurs once).
        prefixSumMap.put(0, 1);
        
        // Iterate through the array.
        for (int num : arr) {
            // Update the current prefix sum.
            prefix_sum += num;
            
            // If there exists a prefix_sum - tar in the map, 
            // then there are subarrays ending at the current index that sum to the target.
            if (prefixSumMap.containsKey(prefix_sum - tar)) {
                count += prefixSumMap.get(prefix_sum - tar);
            }
            
            // Update the frequency of the current prefix sum in the map.
            prefixSumMap.put(prefix_sum, prefixSumMap.getOrDefault(prefix_sum, 0) + 1);
        }
        
        return count;
    }
}
