class Solution {

    // Helper function to perform binary search in a 1D array
    public boolean binarysearch(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        // Standard binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid integer overflow

            if (nums[mid] == target) {
                return true; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in right half
            } else {
                right = mid - 1; // Search in left half
            }
        }
        return false; // Target not found
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // Iterate through each row to find the possible one containing the target
        for (int i = 0; i < matrix.length; i++) {
            // ❌ BUG FIX: Should use matrix[i][0] instead of matrix[1][0]
            int first = matrix[i][0]; // First element of the current row
            int last = matrix[i][matrix[i].length - 1]; // Last element of the current row

            // If target lies within the range of current row, perform binary search
            if (target >= first && target <= last) {
                return binarysearch(matrix[i], target);
            }
        }

        // If no suitable row found
        return false;
    }
}
