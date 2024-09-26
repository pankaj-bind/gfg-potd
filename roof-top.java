class Solution {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        int maxSteps = 0;   // To track the maximum number of consecutive steps
        int currentSteps = 0;  // To track the current sequence of consecutive steps
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                currentSteps++;  // If current building is higher, increase the count
                maxSteps = Math.max(maxSteps, currentSteps);  // Update maxSteps if needed
            } else {
                currentSteps = 0;  // Reset current steps if the sequence breaks
            }
        }
        
        return maxSteps;
    }
}
