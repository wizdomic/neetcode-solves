import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); // stack to store operands

        // iterate over each token in the expression
        for (String c : tokens) {
            switch (c) {
                case "+": // addition
                    stack.add(stack.pop() + stack.pop());
                    break;
                case "-": // subtraction (order matters)
                    int a = stack.pop(); // second operand
                    int b = stack.pop(); // first operand
                    stack.add(b - a);
                    break;
                case "*": // multiplication
                    stack.add(stack.pop() * stack.pop());
                    break;
                case "/": // division (order matters)
                    int e = stack.pop(); // second operand
                    int f = stack.pop(); // first operand
                    stack.add(f / e);
                    break;
                default: // if token is a number, push to stack
                    stack.add(Integer.parseInt(c));
            }
        }

        return stack.pop(); // final result remains on top of stack
    }
}
