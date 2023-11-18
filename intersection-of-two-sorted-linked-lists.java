class Solution {
    public static Node findIntersection(Node head1, Node head2) {
        Node dummy = new Node(0); // Dummy node to simplify code
        Node current = dummy;

        // Traverse both lists
        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                // Add the intersection element to the result list
                current.next = new Node(head1.data);
                current = current.next;

                // Move to the next nodes in both lists
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data < head2.data) {
                // Move to the next node in the first list
                head1 = head1.next;
            } else {
                // Move to the next node in the second list
                head2 = head2.next;
            }
        }

        return dummy.next; // Return the head of the result list (excluding the dummy node)
    }
}