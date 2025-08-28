class Solution {
  private:
    void merge(int low, int mid, int high, std::vector<int> &nums,int &x)
    {
        std::vector<int> temp(high-low+1,0);
        int left = low;
        int right = mid+1;
        int idx = 0;
        while(left <= mid && right <= high)
        {
            if(abs(x - nums[left]) <= abs(x - nums[right])) //Check the absolute difference
            {
                temp[idx++] = nums[left++];
            }
            else
            {
                temp[idx++] = nums[right++];
            }
        }
        while(left <= mid)
        {
            temp[idx++] = nums[left++];
        }
        while(right <= high)
        {
            temp[idx++] = nums[right++];
        }
        for(int i = low; i <= high; i++)
        {
            nums[i] = temp[i-low];
        }
    }
    void mergeSort(int low, int high, std::vector<int> &arr, int &x)
    {
        if(low >= high) return;
        int mid = low + ((high-low)>>1);
        mergeSort(low,mid,arr,x);
        mergeSort(mid+1,high,arr,x);
        merge(low,mid,high,arr,x);
        return;
    }
  public:
    void rearrange(vector<int> &arr, int x) {
        mergeSort(0,arr.size()-1,arr,x);
    }
};
