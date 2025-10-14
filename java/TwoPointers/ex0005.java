public class ex0005 {

    /**
     * Given a string s, return the longest palindromic substring in s.
     *
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param s The input string
     * @return The longest palindromic substring
     */
    public String longestPalindrome(String s){
        if (s==null || s.isEmpty()) return "";

        int left = 0;
        int right = 0;

        for (int i=0;i<s.length();i++){
            int maxLen = Math.min(i+1,s.length()-i)*2+1;
            // in case of the maxLen is less than the current longest palindrome
            if (maxLen < right-left) continue;
            int lenOdd = expandFromMiddle(s, i, i);
            int lenEven = expandFromMiddle(s, i, i+1);
            int len = Math.max(lenOdd, lenEven);
            if (len > right-left){
                left = i - ((len-1)/2);
                right = i + (len/2);
            }

        }
        return s.substring(left,right+1);
    }

    /**
     * Expands from the middle of the string to find the length of the palindrome.
     *
     * @param s The input string
     * @param left The left index
     * @param right The right index
     * @return The length of the palindrome
     */
    public int expandFromMiddle (String s, int left, int right){
        if (s==null || left > right) return 0;
        while (left >=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        ex0005 myo = new ex0005();
        System.out.println(myo.longestPalindrome("babad"));
    }
}