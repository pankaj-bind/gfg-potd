class Solution {
    public int countValid(int n, int[] arr) {
        Set<Integer> allowed = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            allowed.add(i);
        }
        for (int d : arr) {
            allowed.remove(d);
        }
        
        // total n-digit numbers = 9 * 10^(n-1)
        int total = (int)Math.pow(10, n) - (int)Math.pow(10, n - 1);
        
        // If all digits are in arr, then allowed digits = {}
        if (allowed.isEmpty()) {
            return total; // All numbers will contain at least one digit from arr
        }

        // Count how many n-digit numbers can be made using only `allowed` digits
        List<Integer> allowedList = new ArrayList<>(allowed);
        int count = 0;

        // Count of digits that can be used as first digit (no zero)
        int firstDigitChoices = 0;
        for (int d : allowedList) {
            if (d != 0) firstDigitChoices++;
        }

        // If first digit cannot be chosen, then no valid number
        if (firstDigitChoices == 0) {
            return total;
        }

        int otherDigitChoices = allowedList.size();
        count = firstDigitChoices * (int)Math.pow(otherDigitChoices, n - 1);
        
        return total - count;
    }
}