class Solution {
    public long subarrayXor(int arr[], int k) {
        // HashMap to store prefix XORs and their frequency
        Map<Integer, Integer> xorFreq = new HashMap<>();

        int xor = 0; // Initialize XOR of prefix
        long count = 0; // Initialize count of subarrays

        for (int num : arr) {
            // Update the XOR with the current element
            xor ^= num;

            // If XOR equals k, increment count (whole subarray matches)
            if (xor == k) {
                count++;
            }

            // Check if there exists a prefix with XOR = xor ^ k
            int targetXor = xor ^ k;
            count += xorFreq.getOrDefault(targetXor, 0);

            // Update the frequency of the current XOR
            xorFreq.put(xor, xorFreq.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}
