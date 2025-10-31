import java.util.Stack;

class MinStack {

    Stack<Integer> newStack;  // main stack to store all elements
    Stack<Integer> minstack;  // helper stack to track minimum values

    public MinStack() {
        this.newStack = new Stack<>(); // initialize main stack
        this.minstack = new Stack<>(); // initialize min tracking stack
    }

    public void push(int val) {
        newStack.push(val); // push value to main stack

        // if minstack is empty or val is smaller/equal to current min, push val
        // else repeat the current min value to keep stack sizes in sync
        if (minstack.isEmpty() || val <= minstack.peek()) {
            minstack.push(val);
        } else {
            minstack.push(minstack.peek());
        }
    }

    public void pop() {
        newStack.pop();  // remove top from main stack
        minstack.pop();  // remove corresponding top from minstack
    }

    public int top() {
        return newStack.peek(); // return top element of main stack
    }

    public int getMin() {
        return minstack.peek(); // top of minstack always holds current min
    }
}
