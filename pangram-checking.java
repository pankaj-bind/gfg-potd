class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram(String s) {
        // Array to keep track of alphabet presence.
        boolean[] present = new boolean[26];

        // Traverse through the string and mark the corresponding alphabet.
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                // Convert the character to lowercase and mark its presence.
                present[Character.toLowerCase(c) - 'a'] = true;
            }
        }

        // Check if all alphabets are present.
        for (boolean isPresent : present) {
            if (!isPresent) {
                return false;
            }
        }

        return true;
    }
}