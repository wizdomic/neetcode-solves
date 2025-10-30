import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); // to track unique characters in the current window
        int left = 0; // left pointer of sliding window
        int res = 0; // stores length of longest substring without repeating characters

        // expand the window using right pointer
        for (int right = 0; right < s.length(); right++) {
            // if duplicate found, move left pointer until duplicate is removed
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left)); // remove leftmost char from set
                left++; // shrink window from left
            }

            // add current character to set and update max length
            set.add(s.charAt(right));
            res = Math.max(res, right - left + 1); // calculate window length
        }

        return res; // return longest unique substring length
    }
}
