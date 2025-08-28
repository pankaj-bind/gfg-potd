class Solution {
  public:
    bool daysrequired(vector<int> &bloomDay, int mid, int M, int k) {
        int count = 0;
        int boquecount = 0;
        for (int i = 0; i < bloomDay.size(); i++) {
            if (bloomDay[i] <= mid) {
                count++;
            } else {
                boquecount += (count / k);
                count = 0;
            }
        }
        boquecount += count / k;
        return boquecount >= M;
    }

    int minDaysBloom(vector<int> &bloomDay, int k, int m) {
        int n = bloomDay.size();
        if ((long)m * (long)k > n) return -1;

        int low = *min_element(bloomDay.begin(), bloomDay.end());
        int high = *max_element(bloomDay.begin(), bloomDay.end());

        while (low <= high) {
            int mid = (high + low) / 2;
            if (daysrequired(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};

