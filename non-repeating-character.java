class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Step 1: Create a frequency map to store character counts
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        // Step 2: Populate the frequency map
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Step 3: Find the first character with a frequency of 1
        for (char ch : s.toCharArray()) {
            if (frequencyMap.get(ch) == 1) {
                return ch; // Return the first non-repeating character
            }
        }

        // Step 4: If no non-repeating character is found, return '$'
        return '$';
    }
}
