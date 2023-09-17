class Solution
{
    // Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        long[] fibNumbers = new long[n];
        
        if (n >= 1) {
            fibNumbers[0] = 1;
        }
        if (n >= 2) {
            fibNumbers[1] = 1;
        }
        
        for (int i = 2; i < n; i++) {
            fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
        }
        
        return fibNumbers;
    }
}
