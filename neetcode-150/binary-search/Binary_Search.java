class Solution {
    public int search(int[] nums, int target) {
        int left = 0; // left boundary of search range
        int right = nums.length - 1; // right boundary of search range

        // Continue searching while the range is valid
        while (left <= right) {
            // Find the middle index safely (avoids overflow)
            int mid = left + (right - left) / 2;

            // If target found, return its index
            if (nums[mid] == target) {
                return mid;
            }
            // If target is larger, search right half
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, search left half
            else {
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }
}
