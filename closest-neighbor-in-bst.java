class Solution {
    public static int findMaxForN(Node root, int n) {
        // Add your code here.
        int ans = Integer.MIN_VALUE;
        while(root!=null){
            if(root.key==n)return n;
            else if(root.key<n){
                ans=Math.max(ans,root.key);
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
        return ans==Integer.MIN_VALUE?-1:ans;
    }
}