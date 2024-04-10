class Solution{
    static int findSingle(int n, int arr[]){
        // code here
        int x=0;
        for(int i=0;i<n;i++)x^=arr[i];
        return x;
    }
}