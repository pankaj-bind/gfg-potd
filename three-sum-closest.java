class Solution {
    static int threeSumClosest(int[] array, int target) {
        Arrays.sort(array); // Sort the array to use two-pointer technique
        int n = array.length;
        int closestSum = Integer.MAX_VALUE;
        
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = array[i] + array[left] + array[right];
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                } else if (Math.abs(sum - target) == Math.abs(closestSum - target)) {
                    closestSum = Math.max(closestSum, sum);
                }
                
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum; // Found exact match
                }
            }
        }
        
        return closestSum;
    }
}
