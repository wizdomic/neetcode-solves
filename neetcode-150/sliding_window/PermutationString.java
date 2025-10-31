import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26]; // frequency array for letters a-z

        // count frequency of each character in s1
        for (char ch : s1.toCharArray()) {
            count[ch - 'a']++;
        }

        int left = 0; // left pointer for sliding window

        // iterate over s2 using right pointer
        for (int right = 0; right < s2.length(); right++) {
            count[s2.charAt(right) - 'a']--; // decrement count for current char

            // maintain window size equal to s1 length
            if ((right - left + 1) > s1.length()) {
                count[s2.charAt(left) - 'a']++; // restore count when shrinking window
                left++; // move left pointer
            }

            // if count array becomes all zeros, permutation exists
            if (Arrays.equals(count, new int[26])) {
                return true;
            }
        }

        return false; // no permutation found
    }
}
