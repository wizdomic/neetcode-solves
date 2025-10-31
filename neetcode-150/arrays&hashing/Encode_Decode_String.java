import java.util.*;

class Solution {

    public String encode(List<String> strs) {
        // handle null case
        if (strs == null)
            return null;
        // handle empty list case
        if (strs.size() == 0)
            return "";

        StringBuilder sb = new StringBuilder(); // to efficiently build the encoded string

        // iterate over each string in the list
        for (String s : strs) {
            // append string length, a delimiter (#), and then the string itself
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString(); // return the full encoded string
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>(); // to store decoded strings

        // handle null case
        if (str == null)
            return null;
        // handle empty string case
        if (str.length() == 0)
            return list;

        int i = 0; // pointer to track current position
        while (i < str.length()) {
            // find index of delimiter (#) starting from i
            int delimiter = str.indexOf("#", i);

            // extract substring between i and delimiter, convert it to an integer length
            int length = Integer.parseInt(str.substring(i, delimiter));

            // move pointer to start of the actual string content
            i = delimiter + 1;

            // extract the substring using the obtained length and add to list
            list.add(str.substring(i, i + length));

            // move pointer to the end of the current string
            i += length;
        }

        return list; // return list of decoded strings
    }
}
