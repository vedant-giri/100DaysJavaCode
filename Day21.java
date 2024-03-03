// A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution {
    static Node reverse(Node head) {
        if (head.next == null)
            return head;
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }

    public static Node addOne(Node head) {
        // code here.

        Node first = reverse(head);
        Node curr = first;

        int carry = 1;
        while (curr != null) {
            int sum = carry + curr.data;
            curr.data = sum % 10;
            carry = sum / 10;

            if (carry == 0)
                break;

            if (curr.next == null) {
                curr.next = new Node(carry);
                break;
            }
            curr = curr.next;
        }
        return reverse(first);

    }
}
