class Solution {
  public:
    vector<int> nextLargerElement(vector<int> &arr) {
        int n = arr.size();
        vector<int> res(n, -1);
        stack<int> st;

        // Traverse the array twice (simulate circular behavior)
        for (int i = 2 * n - 1; i >= 0; --i) {
            int index = i % n;

            // Maintain monotonic stack
            while (!st.empty() && st.top() <= arr[index]) {
                st.pop();
            }

            // Set result only in first pass
            if (i < n) {
                if (!st.empty()) {
                    res[index] = st.top();
                }
            }

            st.push(arr[index]);
        }

        return res;
    }
};
