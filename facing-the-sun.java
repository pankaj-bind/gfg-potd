// User function Template for Java

class Solution {
    // Returns count of buildings that can see sunlight
    public int countBuildings(int[] height) {
        int count = 0;         // Initialize the count of buildings that can see the sunrise
        int maxHeight = 0;     // Keep track of the maximum height encountered so far

        // Iterate over each building
        for (int i = 0; i < height.length; i++) {
            // If the current building is taller than the maximum height encountered so far
            if (height[i] > maxHeight) {
                count++;             // Increment the count as this building can see the sunrise
                maxHeight = height[i]; // Update the maxHeight to the current building's height
            }
        }

        return count;  // Return the total number of buildings that can see the sunrise
    }
}
