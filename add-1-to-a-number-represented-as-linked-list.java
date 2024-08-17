class Solution {
    // Function to add 1 to a number represented as a linked list
    public Node addOne(Node head) {
        // Step 1: Reverse the linked list
        head = reverseList(head);

        // Step 2: Add 1 to the reversed list
        Node current = head;
        int carry = 1;
        
        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;

            // If no carry left, break out of the loop
            if (carry == 0) break;
            
            // Move to the next node
            if (current.next == null && carry > 0) {
                current.next = new Node(carry);
                carry = 0;
            }
            current = current.next;
        }

        // Step 3: Reverse the list back to original order
        head = reverseList(head);

        return head;
    }

    // Helper function to reverse the linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;  // Store next
            current.next = prev;   // Reverse current node's pointer
            prev = current;        // Move pointers one position ahead
            current = next;
        }
        head = prev;
        return head;
    }
}
