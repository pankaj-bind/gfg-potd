class Solution {
  public:
    string caseSort(string& s) {
        vector<char> upper, lower;

        // Separate uppercase and lowercase characters
        for (char c : s) {
            if (isupper(c))
                upper.push_back(c);
            else
                lower.push_back(c);
        }

        // Sort both vectors
        sort(upper.begin(), upper.end());
        sort(lower.begin(), lower.end());

        // Indices for upper and lower
        int u = 0, l = 0;

        // Build the result
        for (int i = 0; i < s.size(); i++) {
            if (isupper(s[i]))
                s[i] = upper[u++];
            else
                s[i] = lower[l++];
        }

        return s;
    }
};
