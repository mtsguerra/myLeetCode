class ex1945{
    /**
     * Find the lucky number of a string after k transformations.
     *
     * Time complexity: O(n) where n is the length of the string s.
     * Space complexity: O(1) since we are using a constant amount of space.
     *
     * @param s the input string
     * @param k the number of times to apply the lucky number transformation
     * @return the lucky number
     */
    public int getLucky(String s, int k) {
        int accum = 0;
        for (int i=0;i<s.length();i++){
            int crr = s.charAt(i)-'a'+1;
            if (crr >= 10){
                while (crr > 0){
                    accum += crr%10;
                    crr /= 10;
                }
            }
            else {
                accum += crr;
            }
        }
        for (int j=1;j<k;j++){
            int clone = accum;
            accum = 0;
            while (clone > 0){
                accum += clone%10;
                clone /= 10;
            }
        }
        return accum;
    }
}