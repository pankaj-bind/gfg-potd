class Solution {
    static boolean canAttend(int[][] arr) {
        // Sort the meetings by their start time
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        
        // Check for overlapping meetings
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] < arr[i - 1][1]) {
                // If the start time of the current meeting is less than the end time
                // of the previous meeting, return false
                return false;
            }
        }
        
        // If no overlapping meetings found, return true
        return true;
    }
}
