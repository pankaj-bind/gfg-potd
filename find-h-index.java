class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        // Sort the citations array in descending order
        Arrays.sort(citations);
        
        int n = citations.length;
        
        // Traverse through the sorted array and check the H-Index condition
        for (int i = 0; i < n; i++) {
            // Check if the paper at position i has at least (n-i) citations
            if (citations[i] >= n - i) {
                return n - i;  // Return the H-index
            }
        }
        
        // If no H-index is found, return 0
        return 0;
    }
}
