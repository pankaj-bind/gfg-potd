class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // If the array has less than 2 elements, return an empty list
        if (arr.length < 2) {
            return new ArrayList<>();
        }
        
        // Sort the array to use the two-pointer technique
        Arrays.sort(arr);
        
        int left = 0;
        int right = arr.length - 1;
        
        // Initialize variables to track the closest sum and the pair
        int closestSum = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();
        
        // Two-pointer approach
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            // If this sum is closer to the target, update the result
            if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                closestSum = sum;
                result = new ArrayList<>(Arrays.asList(arr[left], arr[right]));
            } 
            // If the sums are equal, choose the pair with the larger absolute difference
            else if (Math.abs(sum - target) == Math.abs(closestSum - target)) {
                if (Math.abs(arr[left] - arr[right]) > Math.abs(result.get(0) - result.get(1))) {
                    result = new ArrayList<>(Arrays.asList(arr[left], arr[right]));
                }
            }
            
            // Move the pointers
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        // Return the result pair
        return result;
    }
}
