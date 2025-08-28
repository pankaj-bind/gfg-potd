class Solution {
  public:
    bool isSubSeq(string& s1, string& s2) {
        // code here
        int m = s1.length(), n = s2.length();
  
    // For s1 to be subsequence, its length must
    // smaller than s2
    if (m > n) return false;
  
    int i = 0, j = 0;
    while (i < m && j < n) {
        if (s1[i] == s2[j])
            i++;
        j++;
    }
  
    return i == m;
    }
};