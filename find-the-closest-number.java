class Solution {
    public static int findClosest(int n, int k, int[] arr) {
        // code here
        int low=0,high=n-1,mid=0,mn=Integer.MAX_VALUE,ans=-1;
        while(low<=high){
            mid=(low+high)/2;
            int diff = Math.abs(arr[mid]-k);
            if(diff<=mn){
                if(diff==mn)ans=Math.max(ans,arr[mid]);
                else ans=arr[mid];
                mn=diff;
            }
            if(arr[mid]<=k)low=mid+1;
            else high=mid-1;
        }
        return ans;
    }

}
