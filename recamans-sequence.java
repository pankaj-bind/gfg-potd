class Solution {
    static ArrayList<Integer> recamanSequence(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>(); // To keep track of elements already in the sequence
        result.add(0); // a(0) = 0
        set.add(0);

        for (int i = 1; i < n; i++) {
            int prev = result.get(i - 1);
            int curr = prev - i;

            // If a(n-1) - n > 0 and not in the sequence
            if (curr > 0 && !set.contains(curr)) {
                result.add(curr);
                set.add(curr);
            } else {
                // Otherwise, a(n-1) + n
                curr = prev + i;
                result.add(curr);
                set.add(curr);
            }
        }

        return result;
    }
}