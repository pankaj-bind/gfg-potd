class Solution
{
    String colName (long n)
    {
        StringBuilder result = new StringBuilder();
        
        while (n > 0) {
            // Reduce n by 1 to handle cases like 'A' = 1, 'B' = 2, ..., 'Z' = 26
            n--;
            char ch = (char) (n % 26 + 'A');
            result.insert(0, ch);
            n = n / 26;
        }
        
        return result.toString();
    }
}