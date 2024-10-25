// User function Template for Java
class Solution {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        // Sort the array to access smallest and largest elements easily
        Arrays.sort(arr);
        
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = arr.length - 1;
        
        // Alternately add largest and smallest elements
        while (i <= j) {
            // Add largest element first
            result.add(arr[j--]);
            
            // Add smallest element if there are still elements left
            if (i <= j) {
                result.add(arr[i++]);
            }
        }
        
        return result;
    }
}
