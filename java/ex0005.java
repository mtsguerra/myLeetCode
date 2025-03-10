public class ex0005 {

    //--------------------------------------------------------------------//
    // on this one we will be starting with two variables to store the start and the end of
    // the palindrome, indexs wise, after that we will iterate through the string, and trying
    // for palindromes, the method used to find the size of the palindrome its one that
    // starts in the middle (current index) and expanding to the sizes until its not a palindrome
    // anymore or if the indexes get to the boundaries, so returning to the first loop, we
    // will use this method two times, one to find the possible even palindrome and the other
    // for the not even palindrome, and we will use the biggest of both to compare to the current
    // palindrome size, defined by the end - start, and in the case of the current palindrome being
    // bigger we will alter the start and end, in the start we will be decreasing 1 from the len
    // because of the case of the palindrome being even we only need to decrease len-1/2,
    // and in the case of not being even the decreasing one from the len would not alter the result
    // now on the substring we add one to the end because the boundary must be until the end+1,
    // so we do not cut out the last character, format being [start,end[

    public String longestPalindrome(String s) {
        if (s==null || s.length() < 1) return "";

        int start=0;
        int end = 0;
        
        for (int i=0;i<s.length();i++){
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end-start){
                start = i - ((len-1)/2);
                end = i + (len/2);
            }
        }

        return s.substring(start, end+1);

    }

    public int expandFromMiddle (String s, int left, int right){
        if (s==null || left > right) return 0;
        while (left >=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    //--------------------------------------------------------------------//

    public static void main(String[] args) {
        ex0005 myo = new ex0005();
        System.out.println(myo.longestPalindrome("abba"));
    }
}
