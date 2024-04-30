class Solution{
    //Function to add two numbers represented by linked list.
    static Node reverse(Node head){
        Node prev=null,curr=head,nxt=null;
        while(curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        Node temp=null;
        while(num1!=null && num1.data==0){
            temp=num1;
            num1=num1.next;
        }
        if(temp!=null)
        temp.next=null;
        while(num2!=null && num2.data==0){
            temp=num2;
            num2=num2.next;
        }
        if(temp!=null)
        temp.next=null;
        if(num1==null && num2==null)return new Node(0);
        if(num1==null)return num2;
        if(num2==null)return num1;
        num1=reverse(num1);
        num2=reverse(num2);
        Node head1=num1,head2=num2;
        temp=new Node(1);
        Node ans=temp;
        int carry=0;
        while(head1!=null && head2!=null){
            int sum = head1.data+head2.data+carry;
            carry=sum/10;
            temp.next=new Node(sum%10);
            temp=temp.next;
            head1=head1.next;
            head2=head2.next;
        }
        while(head1!=null){
            int sum = head1.data+carry;
            carry=sum/10;
            temp.next=new Node(sum%10);
            temp=temp.next;
            head1=head1.next;
        }
        while(head2!=null){
            int sum = head2.data+carry;
            carry=sum/10;
            temp.next=new Node(sum%10);
            temp=temp.next;
            head2=head2.next;
        }
        if(carry!=0)temp.next=new Node(carry);
        return reverse(ans.next);
    }
}
