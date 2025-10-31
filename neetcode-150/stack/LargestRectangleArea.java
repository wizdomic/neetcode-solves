import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>(); // stack stores indices of bars
        int maxArea = 0; // to store max rectangle area found so far
        int n = heights.length;
        
        for (int i = 0; i <= n; i++) {
            // treat height as 0 when reaching the end (to flush stack)
            int currentHeight = (i == n) ? 0 : heights[i];
            
            // when current bar is lower than the bar at stack top
            // pop and calculate area for the popped height
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // height of the popped bar
                // if stack empty, width = i (all previous bars smaller)
                // else width = distance between current index and new top - 1
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width); // update max area
            }
            
            stack.push(i); // push current index to stack
        }
        
        return maxArea; // return max rectangle area in histogram
    }
}
