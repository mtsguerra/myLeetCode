import java.util.*;

class ex1957 {
    /**
     * Given a string s, this method removes consecutive characters that appear
     * more than twice in a row, leaving at most two consecutive characters.
     *
     * Time Complexity: O(n), where n is the length of the string s.
     * Space Complexity: O(n), for the StringBuilder used to build the result.
     *
     * @param s the input string
     * @return the modified string with no more than two consecutive characters
     */
    public String makeFancyString(String s) {
        if (s == null || s.length() < 3) return s;
        if (s.length()==3) {
            if (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2)) return s.substring(0, 2);
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int lastChar = -1;
        for (char c : s.toCharArray()) {
            if (c == lastChar) count++;
            else {
                lastChar = c;
                count = 1;
            }
            if (count > 2) continue;
            sb.append(c);
        }
        return sb.toString();
    }
}