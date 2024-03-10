// Given a stack, the task is to sort it such that the top of the stack has the greatest element.

import java.util.Stack;

public class Day28 {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        Stack<Integer> helper = new Stack<Integer>();
        Stack<Integer> to = new Stack<Integer>();

        return helperSort(s, helper, to);

    }

    public Stack<Integer> helperSort(Stack<Integer> from, Stack<Integer> helper, Stack<Integer> to) {
        if (from.isEmpty())
            return to;

        int min = from.pop();
        while (!from.isEmpty()) {
            if (min > from.peek()) {
                helper.push(min);
                min = from.pop();
            } else {
                helper.push(from.pop());
            }
        }
        to.push(min);

        helperSort(helper, from, to);
        return to;

    }
}
