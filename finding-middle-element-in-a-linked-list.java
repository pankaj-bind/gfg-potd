class Solution {
    int getMiddle(Node head) {
        // If the linked list is empty
        if (head == null) return -1;

        // Initialize two pointers
        Node slow = head;
        Node fast = head;

        // Move fast pointer two steps and slow pointer one step at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // When fast reaches the end, slow will be at the middle
        return slow.data;
    }
}
