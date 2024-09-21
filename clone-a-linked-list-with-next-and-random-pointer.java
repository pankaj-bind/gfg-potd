class Solution {
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        if (head == null) return null;

        // Step 1: Insert the cloned nodes between original nodes
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Set the random pointers of the new nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the original and the cloned list
        curr = head;
        Node copyHead = head.next;
        Node temp = copyHead;
        while (curr != null) {
            curr.next = curr.next.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            curr = curr.next;
            temp = temp.next;
        }

        return copyHead;
    }
}
