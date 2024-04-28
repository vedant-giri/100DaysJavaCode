// Given a singly linked list, delete middle of the linked list. For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5.
// If there are even nodes, then there would be two middle nodes, we need to delete the second middle element. For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
// If the input linked list has single node, then it should return NULL.

class Solution {
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        Node fast = head;
        Node slow = head;
        int count = 0;

        while (fast != null && fast.next != null) {
            count++;
            fast = fast.next.next;
            slow = slow.next;
        }

        Node curr = head;
        while (curr.next != slow) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return head;
    }
}