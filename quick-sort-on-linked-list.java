class GfG {
    public static Node quickSort(Node head) {
        if (head == null || head.next == null) {
            return head; // Base case: empty or single node
        }

        // Partitioning the linked list
        Node pivot = head; // Choose the first node as pivot
        Node leftHead = null, leftTail = null;
        Node rightHead = null, rightTail = null;
        Node curr = head.next;

        // Partition the list into two halves: left and right
        while (curr != null) {
            if (curr.data < pivot.data) {
                // Add to left
                if (leftHead == null) {
                    leftHead = curr;
                    leftTail = leftHead;
                } else {
                    leftTail.next = curr;
                    leftTail = leftTail.next;
                }
            } else {
                // Add to right
                if (rightHead == null) {
                    rightHead = curr;
                    rightTail = rightHead;
                } else {
                    rightTail.next = curr;
                    rightTail = rightTail.next;
                }
            }
            curr = curr.next;
        }

        // Terminate the left and right lists
        if (leftTail != null) leftTail.next = null;
        if (rightTail != null) rightTail.next = null;

        // Recursively sort the left and right halves
        leftHead = quickSort(leftHead);
        rightHead = quickSort(rightHead);

        // Concatenate the left list, pivot, and right list
        if (leftHead == null) {
            pivot.next = rightHead;
            return pivot; // No left part, return pivot with right part
        }

        // If there's a left part, find the tail of left and connect it to pivot
        leftTail = leftHead;
        while (leftTail.next != null) {
            leftTail = leftTail.next;
        }
        leftTail.next = pivot;
        pivot.next = rightHead;

        return leftHead; // New head is the start of the left part
    }
}
