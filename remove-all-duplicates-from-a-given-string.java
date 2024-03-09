class Solution {
    String removeDuplicates(String str) {
        // Using LinkedHashSet to maintain order and remove duplicates
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        
        // Traverse the string and add characters to the set
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        
        // Construct the resultant string from the set
        StringBuilder result = new StringBuilder();
        for (char ch : set) {
            result.append(ch);
        }
        
        return result.toString();
    }
}