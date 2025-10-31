import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>(); // stack to track opening brackets

        // mapping of closing to opening brackets
        Map<Character, Character> pairs = Map.of(
            ')', '(', 
            ']', '[', 
            '}', '{'
        );

        // iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // if it's an opening bracket, push to stack
            if (pairs.containsValue(ch)) {
                stack.push(ch);
            } 
            // if it's a closing bracket, check for valid matching pair
            else if (pairs.containsKey(ch)) {
                // invalid if stack is empty or top of stack doesn't match expected opening
                if (stack.isEmpty() || stack.pop() != pairs.get(ch)) {
                    return false;
                }
            }
        }

        // valid only if all brackets are matched and stack is empty
        return stack.isEmpty();
    }
}
