
class Solution {
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        if (n == 1) {
            return 1; // There's only one element, so it's the equilibrium point.
        }
        
        // Calculate the total sum of the array elements
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        
        long leftSum = 0;
        for (int i = 0; i < n; i++) {
            // Calculate the right sum by subtracting the left sum and the current element from the total sum
            long rightSum = totalSum - leftSum - arr[i];
            
            // Check if the left and right sums are equal
            if (leftSum == rightSum) {
                return i + 1; // Equilibrium point found (1-based indexing)
            }
            
            // Update the left sum for the next iteration
            leftSum += arr[i];
        }
        
        return -1; // No equilibrium point found
    }
}
