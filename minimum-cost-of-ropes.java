class Solution {
    public long minCost(long[] arr) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        
        for (long length : arr) {
            minHeap.add(length);
        }
        
        long totalCost = 0;
        
        while (minHeap.size() > 1) {
            long first = minHeap.poll();
            long second = minHeap.poll();
            
            long cost = first + second;
            totalCost += cost;
            
            minHeap.add(cost);
        }
        
        return totalCost;
    }
}
