class Solution {
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node smallHead = reverse(head.next);
        Node temp = head;
        temp.next.next = head;
        temp.next = null;
        return smallHead;
    }

    public void rearrange(Node odd) {
        Node first = odd;
        Node second = odd.next;
        Node temp = odd.next;
        while (first.next != null && second.next != null) {
            first.next = first.next.next;
            first = first.next;
            second.next = second.next.next;
            second = second.next;
        }

        first.next = reverse(temp);
    }
}
