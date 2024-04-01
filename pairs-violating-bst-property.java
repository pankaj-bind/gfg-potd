class Solution {
    static int k;
    public static int pairsViolatingBST(int n, Node root) {
        // code here
      int cnt=0;
       k=0;
        int arr[] = new int[n];
         inorder(root, arr);
         
        for(int i=0; i<n ;i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] > arr[j])
                cnt++;
            }
        }
        return cnt;
        
    }
    static void inorder(Node root, int arr[]) {
        if (root == null) {
            return;
        }

        inorder(root.left, arr);
       arr[k++]= root.data;
        inorder(root.right, arr);
    }
}
