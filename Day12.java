// Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        Node curr = head;
        List<Integer> list = new ArrayList<>();

        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }

        Collections.sort(list);

        curr = head;
        for (int i = 0; i < list.size(); i++) {
            curr.data = list.get(i);
            curr = curr.next;
        }

        return head;
    }
}
