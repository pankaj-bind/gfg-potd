class Solution
{
    // Function to return list of integers that form the boundary 
    // traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        ArrayList<Integer> result = new ArrayList<>();
        
        if(n == 1) {
            for(int j = 0; j < m; j++)
                result.add(matrix[0][j]);
        }
        else if(m == 1) {
            for(int i = 0; i < n; i++)
                result.add(matrix[i][0]);
        }
        else {
            for(int j = 0; j < m; j++)
                result.add(matrix[0][j]);
            for(int i = 1; i < n; i++)
                result.add(matrix[i][m-1]);
            for(int j = m-2; j >= 0; j--)
                result.add(matrix[n-1][j]);
            for(int i = n-2; i > 0; i--)
                result.add(matrix[i][0]);
        }
        
        return result;
    }
}
