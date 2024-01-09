class Solution {
    int longSubarrWthSumDivByK(int a[], int n, int k) {
        // Complete the function
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            sum += a[i];
            int remainder = ((sum % k) + k) % k;

            if (remainder == 0) {
                maxLength = i + 1; // Update maxLength if the subarray ends at index i
            } else if (prefixSumMap.containsKey(remainder)) {
                // If the remainder is seen before, update maxLength
                maxLength = Math.max(maxLength, i - prefixSumMap.get(remainder));
            } else {
                // Store the first occurrence of remainder
                prefixSumMap.put(remainder, i);
            }
        }

        return maxLength;
    }
}
