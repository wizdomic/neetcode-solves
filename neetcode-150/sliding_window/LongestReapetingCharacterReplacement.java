class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0; // left pointer for sliding window
        int[] count = new int[26]; // store frequency of each uppercase letter
        int maxfrequent = 0; // track the count of most frequent character in window
        int longest = 0; // store length of longest valid substring

        // expand the window by moving the right pointer
        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'A'; // map character to index (0-25)
            count[index]++; // increment count of current character
            maxfrequent = Math.max(maxfrequent, count[index]); // update most frequent count

            // shrink window if replacements needed exceed k
            while ((right - left + 1) - maxfrequent > k) {
                count[s.charAt(left) - 'A']--; // reduce frequency of leftmost char
                left++; // move window's left boundary
            }

            // update longest substring length
            longest = Math.max(longest, right - left + 1);
        }

        return longest; // return length of longest valid substring
    }
}
