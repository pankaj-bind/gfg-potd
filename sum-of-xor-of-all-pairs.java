class Solution{
   
    public long sumXOR (int arr[], int n) {
        long result = 0;
        
        for (int bit = 0; bit < 31; bit++) {
            int countSetBits = 0;
            for (int i = 0; i < n; i++) {
                if ((arr[i] & (1 << bit)) != 0) {
                    countSetBits++;
                }
            }
            
            // Count of 0's in the bit position
            int countUnsetBits = n - countSetBits;
            
            // XOR value for this bit position
            long xorValue = (1L << bit) * countSetBits * countUnsetBits;
            
            result += xorValue;
        }
        
        return result;
    }
}
