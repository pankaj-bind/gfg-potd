class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0;
        int result = 0;

        // Traverse both arrays until one is exhausted
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                sum1 += arr1.get(i++);
            } else if (arr1.get(i) > arr2.get(j)) {
                sum2 += arr2.get(j++);
            } else {
                // Common element found
                result += Math.max(sum1, sum2) + arr1.get(i);  // add the common element once
                sum1 = 0;  // reset sum1
                sum2 = 0;  // reset sum2
                i++;
                j++;
            }
        }

        // Add remaining elements from arr1
        while (i < arr1.size()) {
            sum1 += arr1.get(i++);
        }

        // Add remaining elements from arr2
        while (j < arr2.size()) {
            sum2 += arr2.get(j++);
        }

        // Add the maximum of the remaining sums
        result += Math.max(sum1, sum2);

        return result;
    }
}
