class Solution {
    public String printString(String s, char ch, int count) {
        int occurrences = 0; // Counter for occurrences of ch
        
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                occurrences++;
            }
            
            // If we have found the ch 'count' times
            if (occurrences == count) {
                // Return the remaining substring from the next character
                return s.substring(i + 1);
            }
        }
        
        // If ch does not appear 'count' times, return an empty string
        return "";
    }
}
