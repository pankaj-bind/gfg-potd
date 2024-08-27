class Solution {
    public int findMaxDiff(int[] arr) {
        int n = arr.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        
        // Stack to find the nearest smaller element to the left
        Stack<Integer> stack = new Stack<>();
        
        // Fill the left smaller array
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            leftSmaller[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(arr[i]);
        }
        
        // Clear the stack for right smaller element calculation
        stack.clear();
        
        // Fill the right smaller array
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            rightSmaller[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(arr[i]);
        }
        
        // Calculate the maximum absolute difference
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(leftSmaller[i] - rightSmaller[i]);
            maxDiff = Math.max(maxDiff, diff);
        }
        
        return maxDiff;
    }
}
