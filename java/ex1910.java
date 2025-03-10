import java.util.Stack;

public class ex1910 {

    public String removeOccurrences(String s, String part) {
        // creates a stack to create the final answer
        Stack<Character> stck = new Stack<>();
        int plen = part.length();
        for (char ch : s.toCharArray()) {
            stck.push(ch);
            // checks if the current char is equals to the last char of the part, if not it does not need to be checked
            // also checks if the current stack has the minimum size and at last checks if it is a match with the part
            if (ch == part.charAt(plen-1) && stck.size() >= plen && itMatch(stck, part, plen)){
                for (int i =0;i<plen;i++){
                    stck.pop();
                }
            }
        }
        // creates the stringBuilder to populate it with the characters
        StringBuilder ans = new StringBuilder();
        while (!stck.isEmpty()) {
            ans.append(stck.pop());
        }
        ans.reverse();
        return ans.toString();
    }

    // supportive function to checks if theres a match
    private boolean itMatch(Stack<Character> stck, String part, int plen){
        Stack<Character> temp = new Stack<>();
        temp.addAll(stck);
        // iterates through all the chars in part and if finds a mismatch returns false
        for (int i = plen-1;i>=0;i--){
            char ch = temp.pop();
            if (ch!=part.charAt(i)) return false;
        }
        return true;
    }

    public String removeOccurrences3(String s, String part) {
        // sliding window tec
        int plen = part.length();
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            ans.append(ch);
            // if the current string is of the same size or bigger than the part it checks for the final substring of size part
            // if it is equals to the part it removes it from the sb using setLength to be more efficient
            if (ans.length() >= plen && ans.substring(ans.length()-plen).equals(part)) {
                ans.setLength(ans.length()-plen);
            }
        }
        return ans.toString();
    }

    public String removeOccurrences2(String s, String part) {
        // creates a substring to manipulate the chars as it goes
        StringBuilder ans = new StringBuilder();
        // fill the substring 
        for (char ch : s.toCharArray()) {
            ans.append(ch);
        }
        // find the first index where the part occurs
        int index = ans.toString().indexOf(part);
        // while the part occurs it continues to remove it from
        while (index != -1) {
            ans.replace(index, index+part.length(), "");
            index = ans.toString().indexOf(part);
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        ex1910 myo = new ex1910();
        System.out.println(myo.removeOccurrences("abcfgaabcbc", "abc"));
    }
}