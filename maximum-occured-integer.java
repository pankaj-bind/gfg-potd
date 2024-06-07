class Solution {
    // Function to find the maximum occurred integer in all ranges.
    public static int maxOccured(int n, int l[], int r[], int maxx) {
        int[] count = new int[maxx + 2]; // +2 to handle the case where r[i] is maxx

        // Step 2: Populate the difference array
        for (int i = 0; i < n; i++) {
            count[l[i]]++;
            if (r[i] + 1 <= maxx) {
                count[r[i] + 1]--;
            }
        }

        // Step 3: Compute the prefix sum to get actual counts
        int maxCount = 0, maxOccuredInteger = 0, currentCount = 0;
        for (int i = 0; i <= maxx; i++) {
            currentCount += count[i];
            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxOccuredInteger = i;
            }
        }

        return maxOccuredInteger;
    }
}