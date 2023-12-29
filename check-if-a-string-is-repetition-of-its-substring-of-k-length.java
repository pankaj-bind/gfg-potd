public int kSubstrConcat(int n, String s, int k) {
        if (n % k != 0) {
            return 0;
        }

        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i += k) {
            mp.merge(s.substring(i, i + k), 1, Integer::sum);
        }

        if (mp.size() == 1) {
            return 1;
        }

        if (mp.size() != 2) {
            return 0; // Assuming 0 is used to represent false in C++
        }

        Map.Entry<String, Integer> firstEntry = mp.entrySet().iterator().next();

        if (firstEntry.getValue() == 1 || firstEntry.getValue() == (n / k) - 1) {
            return 1;
        }

        return 0; // Assuming 0 is used to represent false in C++
    }