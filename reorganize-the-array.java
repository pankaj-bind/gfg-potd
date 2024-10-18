class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
        int n = arr.size();
        List<Integer> result = new ArrayList<>();

        // Initialize the result list with -1 for all indices
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }

        // Place the elements in their correct positions
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != -1 && arr.get(i) < n) {
                result.set(arr.get(i), arr.get(i));
            }
        }

        return result;
    }
}
