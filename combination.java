class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(arr, n, k, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] arr, int n, int target, int start, List<Integer> tempList, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < n; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue; // skip duplicates
            tempList.add(arr[i]);
            backtrack(arr, n, target - arr[i], i + 1, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }
}