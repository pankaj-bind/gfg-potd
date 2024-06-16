class Solution {
    public static ArrayList<Integer> getPrimes(int n) {
        // Step 1: Use Sieve of Eratosthenes to find all primes up to n
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not primes
        
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        // Step 2: Collect all primes up to n
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        // Step 3: Find the pair (a, b) such that a + b = n
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);
        
        for (int i = 0; i < primes.size(); i++) {
            int a = primes.get(i);
            int b = n - a;
            if (b >= 2 && isPrime[b]) {
                result.set(0, a);
                result.set(1, b);
                break; // Since we want smallest 'a', we can break early
            }
        }
        
        return result;
    }
}