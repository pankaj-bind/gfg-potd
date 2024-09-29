class Solution {
    int totalCount(int k, int[] arr) {
        int totalParts = 0;
        
        for (int num : arr) {
            // Calculate the number of full parts
            totalParts += num / k;
            
            // If there is a remainder, add one more part
            if (num % k != 0) {
                totalParts++;
            }
        }
        
        return totalParts;
    }
}
