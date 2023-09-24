class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = N-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                int sum = A[i] + B[j];
                
                if (pq.size() < K) {
                    pq.offer(sum);
                } else if (sum > pq.peek()) {
                    pq.poll();
                    pq.offer(sum);
                } else {
                    break; // Since the arrays are sorted, further sums won't be greater
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        
        Collections.reverse(result);
        return result;
    }
}