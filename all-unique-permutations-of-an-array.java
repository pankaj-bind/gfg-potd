class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[n];
        ArrayList<Integer> currentPermutation = new ArrayList<>();

        // Sort the input array to ensure unique permutations are in sorted order
        Collections.sort(arr);

        generatePermutations(arr, n, used, currentPermutation, result);

        return result;
    }

    static void generatePermutations(ArrayList<Integer> arr, int n, boolean[] used,
                                      ArrayList<Integer> currentPermutation,
                                      ArrayList<ArrayList<Integer>> result) {
        if (currentPermutation.size() == n) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i] || (i > 0 && arr.get(i).equals(arr.get(i - 1)) && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            currentPermutation.add(arr.get(i));

            generatePermutations(arr, n, used, currentPermutation, result);

            used[i] = false;
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }
}