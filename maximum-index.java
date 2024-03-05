class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) { 
        
        // Your code here
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        for(int i=n-2; i>=0; i--){
            if(a[i]>a[st.peek()]){
                st.push(i);
            }
        }
        int low=0;
        int ans=0;
        
        while(!st.isEmpty() && low<n){
            if(a[st.peek()]>=a[low]){
                ans=Math.max(ans, st.pop()-low);
            }
            else{
                low++;
            }
        }
        return ans;
    }
}