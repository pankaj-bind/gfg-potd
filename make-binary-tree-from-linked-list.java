class Solution {
    public Tree convert(Node head, Tree node) {
        if (head == null) {
            return null;
        }

        // Initialize the root of the tree with the first element of the linked list
        node = new Tree(head.data);
        head = head.next;

        // Use a queue to perform level order traversal
        Queue<Tree> queue = new LinkedList<>();
        queue.add(node);

        // Traverse the linked list
        while (head != null) {
            // Get the current node from the queue
            Tree current = queue.poll();

            // Create the left child from the linked list and enqueue it
            if (head != null) {
                current.left = new Tree(head.data);
                queue.add(current.left);
                head = head.next;
            }

            // Create the right child from the linked list and enqueue it
            if (head != null) {
                current.right = new Tree(head.data);
                queue.add(current.right);
                head = head.next;
            }
        }

        return node;
    }
}
