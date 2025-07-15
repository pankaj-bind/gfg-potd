class Solution {
  public:
    int countNumbers(int n) {
        int limit = sqrt(n) + 1;
        vector<bool> isPrime(limit + 1, true);
        vector<int> primes;

        // Sieve of Eratosthenes
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= limit; ++i) {
            if (isPrime[i]) {
                primes.push_back(i);
                for (int j = i * 2; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        // Case 1: p^8 <= n
        for (int i = 0; i < primes.size(); ++i) {
            long long p8 = 1LL * pow(primes[i], 8);
            if (p8 <= n) count++;
            else break;
        }

        // Case 2: p^2 * q^2 <= n (p != q)
        for (int i = 0; i < primes.size(); ++i) {
            for (int j = i + 1; j < primes.size(); ++j) {
                long long prod = 1LL * primes[i] * primes[i] * primes[j] * primes[j];
                if (prod <= n) count++;
                else break;
            }
        }

        return count;
    }
};