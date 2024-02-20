// Given head, the head of a singly linked list, find if the linked list is circular or not. A linked list is called circular if it not NULL terminated and all nodes are connected in the form of a cycle. An empty linked list is considered as circular.

// Note: The linked list does not contains any inner loop.

/* Structure of LinkedList
class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
*/
class GfG {

    boolean isCircular(Node head) {
        // Your code here
        Node current = head;

        while (current.next != null) {
            if (current.next == head) {
                return true;
            }
            current = current.next;
        }

        return false;
    }
}
