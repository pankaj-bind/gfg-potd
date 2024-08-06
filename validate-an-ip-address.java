class Solution {

    public boolean isValid(String str) {
        // Split the input string by dots
        String[] parts = str.split("\\.");
        
        // Check if the number of parts is 4
        if (parts.length != 4) {
            return false;
        }
        
        for (String part : parts) {
            // Check if the part is not empty and is a number
            if (part.isEmpty() || !isNumber(part)) {
                return false;
            }
            
            // Convert the part to an integer
            int num = Integer.parseInt(part);
            
            // Check if the number is within the range of 0-255
            if (num < 0 || num > 255) {
                return false;
            }
            
            // Check if the part has leading zeros (except for single digit '0')
            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }
        }
        
        return true;
    }
    
    // Helper function to check if a string is a number
    private boolean isNumber(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
