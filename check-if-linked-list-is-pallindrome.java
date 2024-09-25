class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle of the linked list
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        Node secondHalfHead = reverseList(slow);

        // Step 3: Compare the first half with the reversed second half
        Node firstHalfHead = head;
        Node secondHalfIter = secondHalfHead;
        boolean isPalindrome = true;
        while (secondHalfIter != null) {
            if (firstHalfHead.data != secondHalfIter.data) {
                isPalindrome = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfIter = secondHalfIter.next;
        }

        // Step 4: Restore the list (optional)
        reverseList(secondHalfHead);

        return isPalindrome;
    }

    // Helper function to reverse a linked list
    private Node reverseList(Node head) {
        Node prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
