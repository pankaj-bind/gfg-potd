class Solution {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Insert first k+1 elements into the min heap
        for (int i = 0; i <= k && i < arr.length; i++) {
            minHeap.add(arr[i]);
        }
        
        int index = 0;
        
        // For the rest of the elements, add current element to min heap
        // and remove the smallest one to place it in sorted order
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }
        
        // Remove all remaining elements from the min heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}
