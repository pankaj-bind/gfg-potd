class Solution {
    public int minNumber(int arr[], int N) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        int toInsert = 0;
        while (!isPrime(sum)) {
            sum++;
            toInsert++;
        }

        return toInsert;
    }

    // Function to check if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}