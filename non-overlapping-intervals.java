class Solution {
    static int minRemoval(int[][] intervals) {
        // Sort intervals by their end times
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int count = 0;  // Count of non-overlapping intervals
        int prevEnd = Integer.MIN_VALUE;  // End time of the last non-overlapping interval
        
        for (int[] interval : intervals) {
            // If the current interval overlaps with the previous one
            if (interval[0] < prevEnd) {
                count++;  // Remove the current interval
            } else {
                prevEnd = interval[1];  // Update the end time
            }
        }
        
        return count;
    }
}
