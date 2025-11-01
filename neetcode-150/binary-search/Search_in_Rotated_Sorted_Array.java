class Solution {
    public int search(int[] nums, int target) {
        // Handle edge case: empty array
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        // Modified binary search for rotated sorted array
        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevent integer overflow

            if (nums[mid] == target) {
                return mid; // Target found
            }

            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                // Target lies within the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else { 
                    left = mid + 1; // Search in the right half
                }
            } 
            // Otherwise, right half must be sorted
            else {
                // Target lies within the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
        }

        // Target not found
        return -1;
    }
}
