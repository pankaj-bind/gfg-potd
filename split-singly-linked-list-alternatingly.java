class Solution {
    Node[] alternatingSplitList(Node head) {
        if (head == null) {
            return new Node[] {null, null};
        }

        Node head1 = null, tail1 = null;
        Node head2 = null, tail2 = null;
        Node current = head;
        boolean toggle = true; // This will help in alternating between the lists

        while (current != null) {
            if (toggle) {
                // Add current node to list1
                if (head1 == null) {
                    head1 = current;
                    tail1 = current;
                } else {
                    tail1.next = current;
                    tail1 = tail1.next;
                }
            } else {
                // Add current node to list2
                if (head2 == null) {
                    head2 = current;
                    tail2 = current;
                } else {
                    tail2.next = current;
                    tail2 = tail2.next;
                }
            }
            current = current.next;
            toggle = !toggle; // Switch between the lists
        }

        // At the end of both lists, set the last node's next to null
        if (tail1 != null) tail1.next = null;
        if (tail2 != null) tail2.next = null;

        return new Node[] {head1, head2};
    }
}
