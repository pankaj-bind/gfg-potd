class Solution {
    public static Node insertionSort(Node head_ref) {
        // code here
        if (head_ref == null || head_ref.next == null) {
            return head_ref;
        }

        Node sorted = null;
        Node current = head_ref;

        while (current != null) {
            Node next = current.next;

            if (sorted == null || sorted.data >= current.data) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.next != null && temp.next.data < current.data) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }

            current = next;
        }

        return sorted;
    }
}