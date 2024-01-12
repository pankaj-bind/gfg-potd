class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // Using a stack to reverse the first K elements
        Stack<Integer> stack = new Stack<>();

        // Push the first K elements into the stack
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }

        // Enqueue the elements from the stack back into the queue
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        // Enqueue the remaining elements back into the queue
        for (int i = 0; i < q.size() - k; i++) {
            q.add(q.poll());
        }

        return q;
    }
}