import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>(); // stack to store indices of temperatures
        int n = temperatures.length;
        int[] res = new int[n]; // result array to store days until warmer temperature

        // iterate from right to left
        for (int index = n - 1; index >= 0; index--) {
            // pop stack until a warmer day is found
            while (!stack.isEmpty() && temperatures[index] >= temperatures[stack.peek()]) {
                stack.pop(); // remove cooler or same-temp days
            }

            // if stack not empty, top of stack gives index of next warmer day
            if (!stack.isEmpty()) {
                res[index] = stack.peek() - index; // difference gives days to wait
            }

            // push current day's index onto stack
            stack.push(index);
        }

        return res; // return final result array
    }
}
