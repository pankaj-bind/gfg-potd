class Solution {
    public static String oddEven(String s) {
        int[] frequency = new int[26];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        
        int x = 0, y = 0;
        for (int i = 0; i < 26; i++) {
            int pos = i + 1;  // position in alphabet (1 for 'a', 2 for 'b', ...)
            if (pos % 2 == 0 && frequency[i] % 2 == 0 && frequency[i] > 0) {
                x++;
            } else if (pos % 2 == 1 && frequency[i] % 2 == 1) {
                y++;
            }
        }
        
        int sum = x + y;
        return sum % 2 == 0 ? "EVEN" : "ODD";
    }
}