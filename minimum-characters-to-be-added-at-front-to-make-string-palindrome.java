class Solution {
    public static int minChar(String s) {
        // Create a new string which is the original string + a special character + reversed string
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        
        // Compute LPS (Longest Prefix Suffix) array for this new string
        int n = temp.length();
        int[] lps = new int[n];
        
        int len = 0;
        int i = 1;
        
        while (i < n) {
            if (temp.charAt(i) == temp.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // Minimum characters to be added is the difference between the original string size
        // and the longest palindromic prefix length
        return s.length() - lps[n - 1];
    }
}
