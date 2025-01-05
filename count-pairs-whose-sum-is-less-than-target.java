class Solution {
    int countPairs(int arr[], int target) {
        // Sort the array first
        Arrays.sort(arr);
        
        int left = 0, right = arr.length - 1;
        int count = 0;
        
        // Use two-pointer technique
        while (left < right) {
            // If the sum of the pair is less than the target
            if (arr[left] + arr[right] < target) {
                // All pairs between left and right will have a sum < target
                count += (right - left);
                // Move the left pointer forward
                left++;
            } else {
                // If the sum is >= target, move the right pointer backward
                right--;
            }
        }
        
        return count;
    }
}
