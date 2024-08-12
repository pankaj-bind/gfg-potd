class Solution {
    public int sumOfMiddleElements(int arr1[],int arr2[]) {
        int n = arr1.length, m = arr2.length, k = (n+m)/2;
        if(n>m) return sumOfMiddleElements(arr2,arr1);
        
        int l=Math.max(0,k-m), r=Math.min(n,k), max=Integer.MAX_VALUE, min=Integer.MIN_VALUE;
        
        while(l<=r){
            
            int cut1 = l+(r-l)/2;
            
            int l1 = cut1==0?min:arr1[cut1-1];
            int r1 = cut1==n?max:arr1[cut1];
            
            int cut2 = k - cut1;
            
            int l2 = cut2==0?min:arr2[cut2-1];
            int r2 = cut2==m?max:arr2[cut2];
            
            //correct cut on arr1, arr2
            if(l1<=r2 && l2<=r1){
                if((n+m)%2==0)  return Math.max(l1,l2) + Math.min(r1,r2);
                
                return Math.max(l1,l2);
            }
            //some elements there on arr1 which are greater
            else if(r1<l2){
                //so increase your range
                l=cut1+1;
            }
            else{
                r=cut1-1;
            }
            
        }
        
        return -1;
    }
}
