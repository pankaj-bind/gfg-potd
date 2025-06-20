class Solution {
  public:
    bool validgroup(vector<int> &arr, int k) {
        int n = arr.size();
        if (n % k != 0) return false;

        map<int, int> count;
        for (int num : arr) count[num]++;

        while (!count.empty()) {
            int start = count.begin()->first;  
            for (int i = 0; i < k; ++i) {
                int num = start + i;
                if (count[num] == 0)
                    return false;
                count[num]--;
                if (count[num] == 0)
                    count.erase(num);
            }
        }

        return true;
    }
};