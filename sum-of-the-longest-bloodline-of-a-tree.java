class Solution{
    static int ans = Integer.MIN_VALUE,mxCount=0; 
    static void help(Node root, int sum, int count){
        if(root==null){
            if(count>mxCount){
                ans=sum;
                mxCount=count;
            }
            else if(count==mxCount){
                ans=Math.max(ans,sum);
            }
            return;
        }
        sum+=root.data;
        count++;
        help(root.left,sum,count);
        help(root.right,sum,count);
        
    }
    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here
        int sum=0,count=0;
        ans=Integer.MIN_VALUE;
        mxCount=0;
        help(root,sum,count);
        return ans;
    }
}