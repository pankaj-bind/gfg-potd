class Solution {
  public:
    int splitArray(vector<int>& arr, int k) {
        int low = *max_element(arr.begin(), arr.end());
        int high = accumulate(arr.begin(), arr.end(), 0);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

  private:
    bool isValid(vector<int>& arr, int k, int mid) {
        int count = 1, sum = 0;
        for (int num : arr) {
            if (sum + num > mid) {
                count++;
                sum = num;
                if (count > k) return false;
            } else {
                sum += num;
            }
        }
        return true;
    }
};
