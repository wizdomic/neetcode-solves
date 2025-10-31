import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); // to store all unique triplets
        Arrays.sort(nums); // sort array to easily handle duplicates and use two-pointer
        int n = nums.length;

        // iterate through each number as potential first element
        for (int i = 0; i < n; i++) {
            // skip duplicate elements for the first number
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1; // start pointer after current element
            int right = n - 1; // end pointer at the last element

            // two-pointer approach to find pairs that sum up to -nums[i]
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // found a valid triplet
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // skip duplicates on both sides
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } 
                // if sum is less than zero, move left pointer to increase sum
                else if (sum < 0) {
                    left++;
                } 
                // if sum is greater than zero, move right pointer to decrease sum
                else {
                    right--;
                }
            }
        }
        return res; // return list of unique triplets
    }
}
