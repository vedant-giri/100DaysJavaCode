
// Implement a Queue using 2 stacks s1 and s2 .
// A Query Q is of 2 Types
// (i) 1 x (a query of this type means  pushing 'x' into the queue)
// (ii) 2   (a query of this type means to pop element from queue and print the poped element)

// Note :- If there is no element return -1 as answer while popping.

class StackQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    // Function to push an element in queue by using 2 stacks.
    void Push(int x) {
        // Your code here
        s1.push(x);

    }

    // Function to pop an element from queue by using 2 stacks.
    int Pop() {
        // Your code here
        if (s1.isEmpty() && s2.isEmpty())
            return -1;

        while (s1.size() > 1) {
            s2.push(s1.pop());

        }
        int top = s1.pop();
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return top;
    }
}
