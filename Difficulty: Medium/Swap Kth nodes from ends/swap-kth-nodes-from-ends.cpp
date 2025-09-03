/*
class Node {
  public:
    int data;
    Node *next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};
*/

class Solution {
  public:
    Node* swapKth(Node* head, int k) {
        // code here
        int n=0;
        Node * temp=head;
        while(temp!=NULL){
            n++;
            temp=temp->next;
        }
        int last=n-k+1;
        if(last==k || k>n){
            return head;
        }
        int minVal=min(k,n-k+1);
        int maxVal=max(k,n-k+1);
        k=minVal;
        last=maxVal;
        temp=head;
            Node* prevX = nullptr;
    Node* x = head;
    for (int i = 1; i < k; i++) {
        prevX = x;
        x = x->next;
    }

    // find kth node from end and its prev
    Node* prevY = nullptr;
    Node* y = head;
    for (int i = 1; i < n - k + 1; i++) {
        prevY = y;
        y = y->next;
    }

    // adjust previous pointers
    if (prevX) prevX->next = y;
    if (prevY) prevY->next = x;

    // swap next pointers
    Node* tempNext = x->next;
    x->next = y->next;
    y->next = tempNext;

    // change head if needed
    if (k == 1) head = y;
    if (k == n) head = x;

    return head;
        // return head;
    }
};