import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        // create a set for O(1) lookups to check if a number exists
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); // add all numbers to set
        }

        int longest = 0; // to track the longest consecutive sequence

        // iterate through each number in the set
        for (int num : set) {
            // check if it's the start of a new sequence (no previous number present)
            if (!set.contains(num - 1)) {
                int currentNum = num; // current number being checked
                int length = 1; // sequence length starts at 1

                // continue counting as long as next consecutive numbers exist
                while (set.contains(currentNum + 1)) {
                    currentNum += 1; // move to next number
                    length += 1; // increment sequence length
                }

                // update longest if current sequence is longer
                longest = Math.max(longest, length);
            }
        }

        return longest; // return the longest consecutive sequence length
    }
}
