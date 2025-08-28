class Solution {
  public:
    int countTriangles(vector<int>& arr) {
        
        int count  = 0;
        sort(arr.begin(),arr.end());
        int n = arr.size();
        
        for(int i = n - 1; i >= 2; i--)
        {
            int left = 0, right = i - 1;
            while(left < right)
            {
                if(arr[left] + arr[right] > arr[i])
                {
                    count += (right - left);
                    right--;
                }else left++;
            }
        }
        return count;
    }
};

