class Solution {
    public boolean compute(Node root) {
        // Step 1: Concatenate all strings into one
        StringBuilder sb = new StringBuilder();
        Node current = root;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
        }
        
        // Step 2: Check if concatenated string is palindrome
        String concatenatedString = sb.toString();
        int left = 0;
        int right = concatenatedString.length() - 1;
        
        while (left < right) {
            if (concatenatedString.charAt(left) != concatenatedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
