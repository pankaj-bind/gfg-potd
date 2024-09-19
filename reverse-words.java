class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // Split the string based on the dot "."
        String[] words = str.split("\\.");

        // Reverse the array of words
        int left = 0, right = words.length - 1;
        while (left < right) {
            // Swap words
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        // Join the words back using a dot "."
        return String.join(".", words);
    }
}
