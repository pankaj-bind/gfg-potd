class Solution {
    static Node construct(int arr[][]) {
        // Add your code here.
        int n = arr.length;
        Node mat[][] = new Node[n][n];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                mat[i][j] = new Node(arr[i][j]);   
            }
        }
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(i + 1 < arr.length){
                    mat[i][j].down = mat[i + 1][j];
                }
                
                if(j + 1 < arr.length){
                    mat[i][j].right = mat[i][j + 1];
                }
                
            }
        }
        return mat[0][0];
    }
}
