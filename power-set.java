class Solution {
    public List<String> AllPossibleStrings(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", s, 0);
        Collections.sort(result);
        return result;
    }

    private void backtrack(List<String> result, String current, String s, int index) {
        if (index == s.length()) {
            if (!current.isEmpty()) {
                result.add(current);
            }
            return;
        }

        // Include the current character
        backtrack(result, current + s.charAt(index), s, index + 1);

        // Exclude the current character
        backtrack(result, current, s, index + 1);
    }
}