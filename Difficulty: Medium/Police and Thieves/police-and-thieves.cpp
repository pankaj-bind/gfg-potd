class Solution {
  public:
    int catchThieves(vector<char> &arr, int k) {
        int n = arr.size();
        queue<int> police, thief;
        int count = 0;

        for (int i = 0; i < n; ++i) {
            if (arr[i] == 'P') {
                police.push(i);
            } else if (arr[i] == 'T') {
                thief.push(i);
            }

            // Try to match police and thief
            while (!police.empty() && !thief.empty()) {
                int p = police.front();
                int t = thief.front();
                if (abs(p - t) <= k) {
                    ++count;
                    police.pop();
                    thief.pop();
                } else {
                    if (p < t) {
                        police.pop();
                    } else {
                        thief.pop();
                    }
                }
            }
        }

        return count;
    }
};
