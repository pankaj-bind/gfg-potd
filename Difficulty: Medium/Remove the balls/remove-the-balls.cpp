class Solution {
  public:
    int findLength(vector<int> &color, vector<int> &radius) {
        stack<pair<int, int>> st;
        int n = color.size();
        
        for (int i = 0; i < n; ++i) {
            pair<int, int> curr = {color[i], radius[i]};
            if (!st.empty() && st.top() == curr) {
                st.pop(); // Remove the pair
            } else {
                st.push(curr);
            }
        }
        
        return st.size(); 
    }
};
