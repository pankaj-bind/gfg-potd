class Solution {
  public:
    long long computeCost(vector<int>& heights, vector<int>& cost, int targetHeight) {
        long long totalCost = 0;
        for (int i = 0; i < heights.size(); ++i) {
            totalCost += 1LL * abs(heights[i] - targetHeight) * cost[i];
        }
        return totalCost;
    }

    int minCost(vector<int>& heights, vector<int>& cost) {
        int low = *min_element(heights.begin(), heights.end());
        int high = *max_element(heights.begin(), heights.end());
        long long result = computeCost(heights, cost, heights[0]);

        while (low < high) {
            int mid = low + (high - low) / 2;
            long long cost1 = computeCost(heights, cost, mid);
            long long cost2 = computeCost(heights, cost, mid + 1);
            result = min(cost1, cost2);
            if (cost1 < cost2) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
};
