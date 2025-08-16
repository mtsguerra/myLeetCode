import java.util.*;

class ex1323{
    /**
     * Given a positive integer num consisting only of digits 6 and 9.
     * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
     *
     * Time Complexity: O(n) where n is the number of digits in num.
     * Space Complexity: O(n) for storing the string representation of num.
     *
     * @param num The input number
     * @return The maximum number after changing at most one digit
     */
    public int maximum69Number (int num) {
        StringBuilder ans = new StringBuilder(String.valueOf(num));
        for (int i = 0; i<ans.length();i++){
            if (ans.charAt(i) == '6'){
                ans.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(ans.toString());
    }
}