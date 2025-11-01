class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search to find the minimum element in a rotated sorted array
        while (left < right) {
            int mid = left + (right - left) / 2; // Avoid integer overflow

            // If mid element is greater than rightmost, the min lies in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Otherwise, the min lies in the left half (including mid)
            else {
                right = mid; // ✅ Fix: should not be mid-1, as mid might be the minimum
            }
        }

        // Left and right converge at the index of the smallest element
        return nums[left];
    }
}
