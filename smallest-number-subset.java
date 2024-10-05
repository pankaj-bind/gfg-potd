class Solution {
    public long findSmallest(int[] arr) {
        long res = 1; // Initialize the smallest number that can't be formed
        for (int i = 0; i < arr.length; i++) {
            // If current array element is greater than res, we cannot form res
            if (arr[i] > res) {
                break;
            }
            // Otherwise, add arr[i] to res to form larger sums
            res += arr[i];
        }
        return res;
    }
}
