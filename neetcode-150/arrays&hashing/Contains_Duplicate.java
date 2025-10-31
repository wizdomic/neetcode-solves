import java.util.*;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(); // create a HashSet to store unique numbers
        
        // iterate through each number in the array
        for (int num : nums) {
            if (set.contains(num)) { // if the set already contains the number, it's a duplicate
                return true; // return true because duplicate found
            }
            set.add(num); // otherwise, add the number to the set
        }
        
        return false; // if loop finishes without duplicates, return false
    }
}
