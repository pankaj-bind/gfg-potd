class Solution
{
    private static final int MOD = 1000000007;
    
    public int padovanSequence(int n)
    {
        // Base cases
        if (n == 0 || n == 1 || n == 2) {
            return 1;
        }
        
        // Variables to hold the last three values in the sequence
        int Pn_3 = 1; // P(0)
        int Pn_2 = 1; // P(1)
        int Pn_1 = 1; // P(2)
        int Pn = 0;
        
        // Calculate the Padovan sequence iteratively
        for (int i = 3; i <= n; i++) {
            Pn = (Pn_2 + Pn_3) % MOD;
            // Update the last three values
            Pn_3 = Pn_2;
            Pn_2 = Pn_1;
            Pn_1 = Pn;
        }
        
        return Pn;
    }
}
