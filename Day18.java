// Given a singly linked list of size N. The task is to left-shift the linked list by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.

/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        if (head == null || k == 0)
            return head;

        Node tail = head;

        int length = 1;

        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        k = k % length;

        if (k == 0)
            return head;

        Node newTail = head;

        for (int i = 1; i < k; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        tail.next = head;
        newTail.next = null;

        return newHead;

    }
}
