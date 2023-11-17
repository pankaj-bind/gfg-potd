public static Node reverseDLL(Node head)
{
    //Your code here
    Node current = head;
    Node temp = null;

    // Swap next and prev pointers for all nodes of the doubly linked list
    while (current != null) {
        temp = current.prev;
        current.prev = current.next;
        current.next = temp;
        current = current.prev;
    }

    // Update the head
    if (temp != null) {
        head = temp.prev;
    }

    return head;
}
