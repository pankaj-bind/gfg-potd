class Solution {
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head) {
        // Base case: If the list is empty or has only one node, it is already sorted.
        if (head == null || head.next == null)
            return head;

        // Find the middle of the doubly linked list.
        Node middle = getMiddle(head);

        // Split the doubly linked list into two halves.
        Node nextOfMiddle = middle.next;
        middle.next = null;
        nextOfMiddle.prev = null;

        // Recursively sort the two halves.
        Node left = sortDoubly(head);
        Node right = sortDoubly(nextOfMiddle);

        // Merge the sorted halves.
        return merge(left, right);
    }

    // Helper function to find the middle of the doubly linked list.
    static Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Helper function to merge two sorted doubly linked lists.
    static Node merge(Node left, Node right) {
        if (left == null)
            return right;
        if (right == null)
            return left;

        if (left.data < right.data) {
            left.next = merge(left.next, right);
            left.next.prev = left;
            left.prev = null;
            return left;
        } else {
            right.next = merge(left, right.next);
            right.next.prev = right;
            right.prev = null;
            return right;
        }
    }
}