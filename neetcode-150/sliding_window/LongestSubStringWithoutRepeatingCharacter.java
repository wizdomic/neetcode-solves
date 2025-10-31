import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); // store unique characters in current window
        int left = 0; // left boundary of sliding window
        int maxLen = 0; // stores the length of longest substring

        // move right pointer to expand window
        for (int right = 0; right < s.length(); right++) {
            // if duplicate character found, shrink window from left until it's removed
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left)); // remove leftmost character
                left++; // move left pointer
            }

            // add current character to set (unique window maintained)
            set.add(s.charAt(right));

            // update max length if current window is longer
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen; // return final longest substring length
    }
}
