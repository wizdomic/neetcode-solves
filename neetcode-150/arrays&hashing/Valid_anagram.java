class Solution {
    public boolean isAnagram(String s, String t) {
        // if lengths are different, they can't be anagrams
        if (s.length() != t.length())
            return false;

        int[] counter = new int[26]; // array to count frequency of each character (a-z)

        // increment count for each character in string s
        for (char i : s.toCharArray())
            counter[i - 'a']++;

        // decrement count for each character in string t
        for (char i : t.toCharArray())
            counter[i - 'a']--;

        // if all counts are zero, both strings have identical letters
        for (int i : counter) {
            if (i != 0) // if any count is non-zero, not an anagram
                return false;
        }

        return true; // all counts balanced, hence it's an anagram
    }
}
