class Solution {
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        // Code here
        PriorityQueue<DLLNode> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        int  i =0;
        while(i <= k && head != null){
            pq.add(head);
            head = head.next;
            ++i;
        }
        
        DLLNode newHead = null;
        DLLNode curr = null;
        while(!pq.isEmpty()){
            if(newHead == null){
                newHead = pq.poll();
                newHead.next = null;
                newHead.prev = null;
                curr = newHead;
            }
            else{
                curr.next = pq.poll();
                curr.next.prev = curr;
                curr = curr.next;
            }
            
            if(head != null){
                pq.add(head);
                head = head.next;
            }
        }
        curr.next = null;
        return newHead;
    }
}
