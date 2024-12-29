
class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // Step 1: Create a set for unique elements of the first array
        Set<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }

        // Step 2: Create a set for the result to store intersection elements
        Set<Integer> resultSet = new HashSet<>();

        // Step 3: Iterate through the second array
        for (int num : b) {
            if (setA.contains(num)) {
                resultSet.add(num);
            }
        }

        // Step 4: Convert resultSet to ArrayList and return
        ArrayList<Integer> result = new ArrayList<>(resultSet);
        return result;
    }
}
