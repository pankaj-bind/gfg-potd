class Solution {
    static int isPerfectNumber(long N) {
        if (N == 1) {
            return 0; // 1 is not a perfect number
        }

        long sum = 1;
        for (long i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                sum += i;
                if (i != N / i) {
                    sum += N / i;
                }
            }
        }

        if (sum == N) {
            return 1;
        } else {
            return 0;
        }
    }
}
