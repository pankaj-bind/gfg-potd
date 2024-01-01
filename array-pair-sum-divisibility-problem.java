class Solution {
    public boolean canPair(int[] nums, int k) {
        if (nums.length % 2 != 0) {
            // If the array length is odd, it is not possible to form pairs
            return false;
        }

        Map<Integer, Integer> remainderCount = new HashMap<>();

        // Count the occurrences of each remainder when divided by k
        for (int num : nums) {
            int remainder = (num % k + k) % k; // Handle negative numbers
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        // Check if each remainder has a valid pair
        for (int remainder : remainderCount.keySet()) {
            if (remainder == 0) {
                // For remainder 0, the count must be even
                if (remainderCount.get(remainder) % 2 != 0) {
                    return false;
                }
            } else {
                // For other remainders, there must be a corresponding remainder to form pairs
                int complement = k - remainder;
                if (!remainderCount.containsKey(complement) || remainderCount.get(remainder) != remainderCount.get(complement)) {
                    return false;
                }
            }
        }

        return true;
    }
}