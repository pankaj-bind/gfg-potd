class Solution {
    public Node deleteNode(Node head, int x) {
        if (head == null) {
            return null;  // If the list is empty, return null
        }

        if (x == 1) {
            // Special case: if we need to delete the head node
            Node newHead = head.next;
            if (newHead != null) {
                newHead.prev = null;  // Update the prev pointer of the new head
            }
            return newHead;  // Return the new head
        }

        Node current = head;
        int count = 1;

        // Traverse the list to find the node at position x
        while (current != null && count < x) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return head;  // If x is greater than the number of nodes, return the original head
        }

        // Update the next and prev pointers to exclude the current node
        if (current.prev != null) {
            current.prev.next = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

        return head;  // Return the original head as the starting point of the modified list
    }
}
