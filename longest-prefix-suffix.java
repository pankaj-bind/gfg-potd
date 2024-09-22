
// User function Template for Java

class Solution {
    int lps(String str) {
        int n = str.length();
        
        // Array to store the length of the longest proper prefix which is also a suffix
        int[] lps = new int[n];
        int len = 0;  // length of the previous longest prefix suffix
        int i = 1;
        
        // Loop to calculate the lps array
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // If mismatch after len matches, we do not match `lps[len-1]` characters, 
                // as they will match anyway. Consider the next candidate lps[len-1].
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // The last value of lps array will give us the length of the longest prefix which is also a suffix.
        return lps[n - 1];
    }
}
