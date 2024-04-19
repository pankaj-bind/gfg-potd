class Solution
{
    ArrayList<Integer> findMissing(int a[], int b[], int n, int m)
    {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Create a HashSet to store elements of array b
        HashSet<Integer> setB = new HashSet<>();
        for (int num : b) {
            setB.add(num);
        }
        
        // Iterate through array a
        for (int num : a) {
            // If the element is not present in setB, add it to the result
            if (!setB.contains(num)) {
                result.add(num);
            }
        }
        
        return result;
    }
}