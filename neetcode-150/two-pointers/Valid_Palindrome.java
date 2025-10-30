class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder filteredOne = new StringBuilder();

        // filter only alphanumeric characters and convert to lowercase
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) { // ignore spaces and punctuation
                filteredOne.append(Character.toLowerCase(ch)); // normalize case
            }
        }

        String string1 = filteredOne.toString(); // original cleaned string
        String string2 = filteredOne.reverse().toString(); // reversed version
        return string1.equals(string2); // true if palindrome
    }
}
