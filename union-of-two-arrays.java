class Solution {
    public static int findUnion(int a[], int b[]) {
        // Create a HashSet to store unique elements from both arrays
        Set<Integer> unionSet = new HashSet<>();

        // Add elements from the first array to the set
        for (int num : a) {
            unionSet.add(num);
        }

        // Add elements from the second array to the set
        for (int num : b) {
            unionSet.add(num);
        }

        // Return the size of the set, which represents the count of unique elements
        return unionSet.size();
    }
}
