// Given a stack, delete the middle element of the stack without using any additional data structure.
// Middle element:- floor((size_of_stack+1)/2) (1-based indexing) from bottom of the stack.

// Note: The output shown by the compiler is the stack from top to bottom.

class Solution {
    // Function to delete middle element of a stack.
    public void deleted(Stack<Integer> s, int sizeOfStack, int current) {
        if (sizeOfStack == 0)
            return;
        int k = (sizeOfStack / 2) + 1;
        if (current == k) {
            s.pop();
            return;
        }
        int top = s.pop();
        deleted(s, sizeOfStack, current + 1);
        s.push(top);

    }

    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        // code here

        deleted(s, sizeOfStack, 1);

    }

}
