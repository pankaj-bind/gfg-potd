class Solution {
    // Function to find all elements in the array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) {
        // Calculate the required frequency for an element to appear more than n/k times.
        int requiredFrequency = n / k;

        // Create a hashmap to store the frequency of each element in the array.
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Traverse the array and populate the frequencyMap.
        for (int i = 0; i < n; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        // Count the elements with frequency greater than n/k.
        int count = 0;
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) > requiredFrequency) {
                count++;
            }
        }

        return count;
    }
}