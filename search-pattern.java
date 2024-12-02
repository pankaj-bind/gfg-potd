class Solution {
    
    // Function to compute the LPS (Longest Prefix Suffix) array
    private int[] computeLPSArray(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int length = 0;  // length of the previous longest prefix suffix
        int i = 1;  // We start calculating from the second character

        // Loop through the pattern
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];  // Backtrack in the LPS array
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Function to search for the pattern in the given text using KMP algorithm
    public ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();
        
        // Compute the LPS array for the pattern
        int[] lps = computeLPSArray(pat);
        
        int i = 0;  // Index for txt[]
        int j = 0;  // Index for pat[]
        
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            
            if (j == m) {
                // Pattern found at index (i - j)
                result.add(i - j);
                j = lps[j - 1];  // Reset j based on LPS array
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];  // Use the LPS to skip unnecessary checks
                } else {
                    i++;
                }
            }
        }
        return result;
    }
}
