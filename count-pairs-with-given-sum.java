class Solution {

    int countPairs(int arr[], int target) {
        // HashMap to store the frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Iterate through the array
        for (int num : arr) {
            // Check if there is a complement that sums to target
            int complement = target - num;
            if (map.containsKey(complement)) {
                // If complement exists, add its frequency to the count
                count += map.get(complement);
            }

            // Add the current number to the map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
