class Solution
{
    int columnWithMaxZeros(int arr[][], int N)
    {
        int maxZeros = 0;
        int maxZerosColumn = -1;
        
        for (int j = 0; j < N; j++) {
            int zerosInColumn = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i][j] == 0) {
                    zerosInColumn++;
                }
            }
            
            if (zerosInColumn > maxZeros) {
                maxZeros = zerosInColumn;
                maxZerosColumn = j;
            }
        }
        
        return maxZerosColumn;
    }
}
