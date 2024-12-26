// User function Template for Java

class Solution {
    boolean twoSum(int arr[], int target) {
        // Create a HashSet to store the elements
        Set<Integer> seen = new HashSet<>();
        
        // Traverse the array
        for (int num : arr) {
            int complement = target - num;
            
            // Check if the complement exists in the set
            if (seen.contains(complement)) {
                return true; // Found a pair
            }
            
            // Add the current number to the set
            seen.add(num);
        }
        
        // No pair found
        return false;
    }
}
