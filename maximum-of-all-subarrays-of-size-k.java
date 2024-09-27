class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < arr.length; i++) {
            // Remove elements from the back of the deque
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.removeLast();
            }
            // Add current element's index at the back of the deque
            deque.addLast(i);
            
            // Remove the elements which are out of this window
            if (deque.peekFirst() == i - k) {
                deque.removeFirst();
            }
            
            // The first k elements are processed, add to result
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]); // the front of the deque is the largest element
            }
        }
        
        return result;
    }
}
