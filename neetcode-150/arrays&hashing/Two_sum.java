import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // create a map to store number and its index for quick lookup
        Map<Integer, Integer> map = new HashMap<>();

        // iterate through each number in array
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i]; // find the required number to reach target

            // if compliment exists in map, return its index and current index
            if (map.containsKey(compliment)) {
                return new int[] { map.get(compliment), i };
            }

            // store current number with its index for future lookup
            map.put(nums[i], i);
        }

        // return empty array if no valid pair found
        return new int[0];
    }
}
