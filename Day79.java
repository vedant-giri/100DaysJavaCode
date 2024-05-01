// Given a singly linked list having n nodes containing english alphabets ('a'-'z'). Rearrange the linked list in such a way that all the vowels come before the consonants while maintaining the order of their arrival.  

/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {

    public Node arrangeCV(Node head) {
        // write code here and return the head of changed linked list

        Node vowel = new Node('1');
        Node v = vowel;

        Node constant = new Node('1');
        Node c = constant;

        while (head != null) {
            if (isVowel(head.data)) {
                v.next = new Node(head.data);
                v = v.next;
            } else {
                c.next = new Node(head.data);
                c = c.next;
            }
            head = head.next;
        }
        v.next = constant.next;

        return vowel.next;
    }

    public static boolean isVowel(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
            return true;
        return false;
    }
}
