class Solution {
  public:
    int nonLisMaxSum(vector<int>& arr) {
        // code here
        int n = arr.size();

        vector<int> len(n, 1); // Length of LIS ending at i

        vector<int> sum(n); // Sum of LIS ending at i

 

        for (int i = 0; i < n; i++) {

            sum[i] = arr[i]; // Initialize with just the element itself

        }

 

        int maxLen = 1;

        int minLISsum = arr[0];

 

        for (int i = 1; i < n; ++i) {

            for (int j = 0; j < i; ++j) {

                if (arr[i] > arr[j]) {

                    if (len[j] + 1 > len[i]) {

                        len[i] = len[j] + 1;

                        sum[i] = sum[j] + arr[i];

                    } else if (len[j] + 1 == len[i]) {

                        sum[i] = min(sum[i], sum[j] + arr[i]);

                    }

                }

            }

 

            // Track max LIS length

            if (len[i] > maxLen) {

                maxLen = len[i];

                minLISsum = sum[i];

            } else if (len[i] == maxLen) {

                minLISsum = min(minLISsum, sum[i]);

            }

        }

 

        // Total sum of array

        int totalSum = 0;

        for (int val : arr) {

            totalSum += val;

        }

 

        return totalSum - minLISsum;
    }
};
