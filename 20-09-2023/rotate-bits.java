class Solution
{
    ArrayList<Integer> rotate(int N, int D)
    {
        ArrayList<Integer> result = new ArrayList<>();
        
        String binary = String.format("%16s", Integer.toBinaryString(N)).replace(' ', '0');
        
        D %= 16; // Take modulus to handle large values of D
        
        String leftRotation = binary.substring(D) + binary.substring(0, D);
        String rightRotation = binary.substring(16 - D) + binary.substring(0, 16 - D);
        
        result.add(Integer.parseInt(leftRotation, 2));
        result.add(Integer.parseInt(rightRotation, 2));
        
        return result;
    }
}
