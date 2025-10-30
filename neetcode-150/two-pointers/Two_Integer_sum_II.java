class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2]; // to store the final indices (1-based)
        int left = 0; // left pointer at start
        int right = numbers.length - 1; // right pointer at end

        // two-pointer approach since array is sorted
        while (left < right) {
            int sum = numbers[left] + numbers[right]; // calculate current sum

            if (sum == target) {
                // found the pair; store 1-based indices
                result[0] = left + 1;
                result[1] = right + 1;
                break; // can break since only one pair exists
            } else if (sum < target) {
                left++; // move left pointer to increase sum
            } else {
                right--; // move right pointer to decrease sum
            }
        }

        return result; // return indices
    }
}
