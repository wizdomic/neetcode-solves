import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // map to group anagrams together
        // key = sorted version of the word, value = list of words (anagrams)
        Map<String, List<String>> map = new HashMap<>();

        // iterate through each string in the array
        for (String s : strs) {
            // convert string to char array to sort alphabetically
            char[] arr = s.toCharArray();
            Arrays.sort(arr); // sorting ensures all anagrams share the same key
            String sorted = new String(arr); // convert back to string

            // if sorted key not in map, create new list, else add to existing list
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
        }

        // convert map values (lists of anagrams) into a list and return
        return new ArrayList<>(map.values());
    }
}
