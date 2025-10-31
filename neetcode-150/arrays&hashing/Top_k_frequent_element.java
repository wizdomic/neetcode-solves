import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: create a frequency map to count occurrences of each number
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); // increment count for each number
        }

        // Step 2: get all unique numbers as a list for sorting
        List<Integer> list = new ArrayList<>(map.keySet());

        // Step 3: sort the list in descending order based on frequency count
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        // Step 4: take the top k elements from sorted list
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i); // assign top k frequent numbers
        }

        // Step 5: return the result array
        return res;
    }
}
