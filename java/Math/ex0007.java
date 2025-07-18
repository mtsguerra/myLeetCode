public class ex0007 {

    /**
     * Reverses the digits of a signed 32-bit integer. Returns 0 if the
     * result overflows.
     *
     * Approach:
     * 1. Initialize a variable to store the reversed integer.
     * 2. Use a loop to extract the last digit of the integer and append it
     * 3. Checking for overflow conditions:
     *
     * Time complexity: O(log n) where n is the number of digits in x.
     * Space complexity: O(1) since we are using a constant amount of space.
     *
     * @param x the integer to be reversed
     * @return the reversed integer
     */
    public int reverse(int x) {
        int finalInt = 0;
        while (x!=0){
            int digit = x%10;
            x/= 10;
            // Check for overflow
            if (finalInt > Integer.MAX_VALUE/10
                || (finalInt == Integer.MAX_VALUE/10 && digit > 7)) return 0;
            if (finalInt < Integer.MIN_VALUE/10
                || (finalInt == Integer.MIN_VALUE/10 && digit < -8)) return 0;
            finalInt = finalInt * 10 + (x%10);

        }
        return finalInt;
    }   

    public static void main(String[] args) {
        ex0007 myo= new ex0007();
        System.out.println(myo.reverse(1534236469));
    }

}
