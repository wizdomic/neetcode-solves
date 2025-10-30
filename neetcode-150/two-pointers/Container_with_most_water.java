class Solution {
    public int maxArea(int[] heights) {
        int left = 0; // pointer starting from left
        int right = heights.length - 1; // pointer starting from right
        int maxAreas = 0; // stores the maximum area found so far

        // use two-pointer approach
        while (left < right) {
            // height is limited by the shorter line
            int height = Math.min(heights[left], heights[right]);
            // calculate area between current left and right
            int area = height * (right - left);
            // update max area if current is larger
            maxAreas = Math.max(area, maxAreas);

            // move the pointer at the shorter line inward to find potential larger area
            while (left < right && heights[left] <= height)
                left++;
            while (left < right && heights[right] <= height)
                right--;
        }

        return maxAreas; // return the maximum area found
    }
}
