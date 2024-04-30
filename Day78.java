// Given two decimal numbers, num1 and num2, represented by linked lists of size n and m respectively. The task is to return a linked list that represents the sum of these two numbers.

// For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null. Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.

// Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    // Function to add two numbers represented by linked list.
    public static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node prev = null;
        Node next = null;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static Node addTwoLists(Node num1, Node num2) {
        // code here
        // return head of sum list
        if (num1 == null)
            return num2;
        else if (num2 == null)
            return num1;
        Node dummy = new Node(-1);
        Node itr = dummy;
        Node temp1 = reverse(num1);
        Node temp2 = reverse(num2);
        int carry = 0;
        while (temp1 != null || temp2 != null || carry != 0) {

            int sum = (temp1 != null ? temp1.data : 0) + (temp2 != null ? temp2.data : 0) + carry;

            carry = sum / 10;
            itr.next = new Node(sum % 10);
            itr = itr.next;
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;

        }

        Node res = reverse(dummy.next);

        while (res.data == 0 && res.next != null) {
            res = res.next;

        }
        if (res.next == null) {
            return new Node(0);
        } else {
            return res;
        }
    }
}