class Solution
{
    //Function to return sum of upper and lower triangles of a matrix.
    static ArrayList<Integer> sumTriangles(int matrix[][], int n)
    {
        ArrayList<Integer> ans= new ArrayList<>();
        int upperSum=0, lowerSum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(j>=i) upperSum+=matrix[i][j];
                if(j<=i) lowerSum+=matrix[i][j];
            }
        }
        ans.add(upperSum);
        ans.add(lowerSum);

        return ans;
    }
}