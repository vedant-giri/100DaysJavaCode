// Given a link list of size N, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be same as that in the original list.

// NOTE: Don't create a new linked list, instead rearrange the provided one.

//User function Template for Java

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
    Node divide(int N, Node head) {
        // code here
        ArrayList<Integer> listEven = new ArrayList<Integer>();
        ArrayList<Integer> listOdd = new ArrayList<Integer>();
        Node curr = head;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                listEven.add(curr.data);
            } else {
                listOdd.add(curr.data);
            }
            curr = curr.next;
        }
        int size1 = listEven.size();
        int size2 = listOdd.size();
        Node node = head;
        for (int i = 0; i < N; i++) {
            if (i < size1) {
                node.data = listEven.get(i);
            } else {
                node.data = listOdd.get(i - size1);

            }
            node = node.next;

        }

        return head;
    }
}
