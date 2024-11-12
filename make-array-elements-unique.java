class Solution {
    public int minIncrements(int[] arr) {
        // Sort the array
        Arrays.sort(arr);
        
        int increments = 0;
        
        // Make each element unique
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                // Increment current element to make it unique
                int neededIncrement = arr[i - 1] + 1 - arr[i];
                arr[i] += neededIncrement;
                increments += neededIncrement;
            }
        }
        
        return increments;
    }
}
