class Solution {
    public boolean findTriplet(int[] arr) {
        // Sort the array to simplify the pair-sum check.
        Arrays.sort(arr);
        int n = arr.length;

        // Iterate through each element in arr as the potential 'third' element of a triplet.
        for (int i = n - 1; i >= 2; i--) {
            int target = arr[i]; // the third element
            int left = 0, right = i - 1;

            // Use two-pointer technique to find if there's a pair with sum equal to target
            while (left < right) {
                int sum = arr[left] + arr[right];
                
                if (sum == target) {
                    return true;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}
