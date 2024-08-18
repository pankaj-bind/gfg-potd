class Solution {
    public boolean canSplit(int arr[]) {
        int totalSum = 0;
        
        // Calculate total sum of the array
        for (int num : arr) {
            totalSum += num;
        }
        
        // If total sum is odd, it's not possible to split the array
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int prefixSum = 0;
        int target = totalSum / 2;
        
        // Traverse the array to find the split point
        for (int num : arr) {
            prefixSum += num;
            
            // If prefix sum equals target (i.e., half of total sum), return true
            if (prefixSum == target) {
                return true;
            }
        }
        
        // If no such split is found, return false
        return false;
    }
}

