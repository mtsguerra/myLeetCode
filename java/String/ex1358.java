class ex1358 {
    /**
     * 1358 This exercise is about finding the number of substrings of a given string that have at least one of each
     * of the respective characters 'a', 'b' and 'c'.
     * The method used to find it is the sliding window technique.
     * @param s The original string.
     * @return The number of substrings that have at least one of each of the characters 'a', 'b' and 'c'.
     */
    public int numberOfSubstrings(String s) {
        int[] abcCount = new int[3];
        int diffABC = 0;
        int sz = s.length();
        int left=0;
        int result = 0;
        for (int right =0;right<sz;right++){
            char ch = s.charAt(right);
            if (ch-'a' >= 0 && ch-'a' <= 2){
                if (abcCount[ch-'a']++ == 0){
                    diffABC++;
                }
            }
            while (diffABC==3 && left<=right){
                result += sz - right;
                char leftChar = s.charAt(left);
                if (leftChar-'a' >= 0 && leftChar-'a' <= 2){
                    if (--abcCount[leftChar-'a']==0){
                        diffABC--;
                    }
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ex1358 sol = new ex1358();
        System.out.println(sol.numberOfSubstrings("abcabc"));
    }
}