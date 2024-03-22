class Solution {
    public static List<List<Long>> multiply(List<List<Long>> A, List<List<Long>> B, long m) {
        int size = A.size();
        List<List<Long>> result = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            result.add(new ArrayList<Long>());
            for (int j = 0; j < size; ++j) {
                long sum = 0;
                for (int k = 0; k < size; ++k) {
                    sum += A.get(i).get(k) * B.get(k).get(j);
                    sum %= m;
                }
                result.get(i).add(sum);
            }
        }
        return result;
    }

    public static long genFibNum(long a, long b, long c, long n, long m) {
        if (n <= 2)
            return 1L % m;
        List<List<Long>> mat = new ArrayList<>();
        mat.add(List.of(a, b, 1L));
        mat.add(List.of(1L, 0L, 0L));
        mat.add(List.of(0L, 0L, 1L));
        
        List<List<Long>> res = new ArrayList<>();
        res.add(List.of(1L, 0L, 0L));
        res.add(List.of(0L, 1L, 0L));
        res.add(List.of(0L, 0L, 1L));

        n -= 2;
        while (n > 0) {
            if ((n & 1) == 1)
                res = multiply(res, mat, m);
            mat = multiply(mat, mat, m);
            n >>= 1;
        }
        return (res.get(0).get(0) + res.get(0).get(1) + c * res.get(0).get(2)) % m;
    }
};