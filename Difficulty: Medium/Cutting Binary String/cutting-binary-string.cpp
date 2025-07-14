
class Solution {
public:
    unordered_set<string> powerOf5;

    // Precompute all binary strings that are powers of 5 and length <= 30
    void generatePowerOf5() {
        long long num = 1;
        while (true) {
            string bin = bitset<64>(num).to_string();
            // Remove leading zeros
            bin = bin.substr(bin.find('1'));
            if (bin.size() > 30) break;
            powerOf5.insert(bin);
            num *= 5;
        }
    }

    int dp[31]; // dp[i] stores minimum cuts from index i to end

    int dfs(string& s, int idx) {
        if (idx == s.size()) return 0; // no more cuts needed
        if (dp[idx] != -1) return dp[idx];

        int minCuts = INT_MAX;
        string curr = "";

        for (int j = idx; j < s.size(); ++j) {
            curr += s[j];
            if (curr[0] == '0') break; // leading zero, invalid
            if (powerOf5.count(curr)) {
                int nextCuts = dfs(s, j + 1);
                if (nextCuts != INT_MAX) {
                    minCuts = min(minCuts, 1 + nextCuts);
                }
            }
        }

        return dp[idx] = minCuts;
    }

    int cuts(string s) {
        generatePowerOf5();
        memset(dp, -1, sizeof(dp));
        int res = dfs(s, 0);
        return res == INT_MAX ? -1 : res;
    }
};