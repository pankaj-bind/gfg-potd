class Solution {
    public Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);

        // Case 1: If the linked list is empty
        if (head == null) {
            newNode.next = newNode; // Point to itself
            return newNode; // Set new node as the head
        }

        // Case 2: If the new node should be inserted before the head
        if (data <= head.data) {
            Node last = getLastNode(head);
            newNode.next = head;
            last.next = newNode; // Update last node's next to the new node
            return newNode; // Set new node as the head
        }

        // Case 3: Traverse the linked list to find the appropriate position to insert
        Node current = head;
        while (current.next != head && current.next.data < data) {
            current = current.next;
        }

        // Insert the new node after the current node
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    // Helper function to get the last node in the circular linked list
    private Node getLastNode(Node head) {
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        return temp;
    }
}
