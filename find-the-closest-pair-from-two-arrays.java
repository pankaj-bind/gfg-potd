class Solution {
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest(int arr[], int brr[], int n, int m, int x) {
        ArrayList<Integer> result = new ArrayList<>();
        int diff = Integer.MAX_VALUE;
        
        int left = 0, right = m - 1;
        int res_l = 0, res_r = 0;
        
        while (left < n && right >= 0) {
            int sum = arr[left] + brr[right];
            if (Math.abs(sum - x) < diff) {
                res_l = left;
                res_r = right;
                diff = Math.abs(sum - x);
            }
            
            if (sum > x) {
                right--;
            } else {
                left++;
            }
        }
        
        result.add(arr[res_l]);
        result.add(brr[res_r]);
        return result;
    }
}