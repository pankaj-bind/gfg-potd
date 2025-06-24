class Solution {
  public:
    string maxSubseq(string& s, int k) {
        int n = s.size();
        int keep = n - k;
        string result;

        for (char c : s) {
            // While there's something to remove and the last char in result is smaller
            while (!result.empty() && result.back() < c && k > 0) {
                result.pop_back();
                k--;
            }
            result.push_back(c);
        }

        // Only return the first `keep` characters (if we didn't remove enough)
        return result.substr(0, keep);
    }
};
