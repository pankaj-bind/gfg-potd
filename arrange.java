class Solution {
    
    public Node arrangeCV(Node head){
        if (head == null || head.next == null)
            return head;
        
        Node vowelHead = null, vowelTail = null;
        Node consonantHead = null, consonantTail = null;
        
        Node current = head;
        
        while (current != null) {
            if (isVowel(current.data)) {
                if (vowelHead == null) {
                    vowelHead = current;
                    vowelTail = current;
                } else {
                    vowelTail.next = current;
                    vowelTail = vowelTail.next;
                }
            } else {
                if (consonantHead == null) {
                    consonantHead = current;
                    consonantTail = current;
                } else {
                    consonantTail.next = current;
                    consonantTail = consonantTail.next;
                }
            }
            current = current.next;
        }
        
        // Connect the last node of vowel list to the first node of consonant list
        if (vowelTail != null)
            vowelTail.next = consonantHead;
        
        // Ensure that the last node of the consonant list points to null
        if (consonantTail != null)
            consonantTail.next = null;
        
        // Return the head of the rearranged list
        return (vowelHead != null) ? vowelHead : consonantHead;
    }
    
    // Function to check if a character is a vowel
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
