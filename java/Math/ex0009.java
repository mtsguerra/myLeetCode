public class ex0009 {

    /**
     * Checks if an integer is a palindrome.
     *
     * Approach:
     * 1. If the number is negative or ends with 0 (and is not 0), it cannot
     * be a palindrome.
     * 2. Initialize a variable to store the reversed integer.
     * 3. Use a loop to extract the last digit of the integer and append it
     * to the reversed integer.
     * 4. Check if the original number is equal to the reversed number or
     *
     * Time complexity: O(log n) where n is the number of digits in x.
     * Space complexity: O(1) since we are using a constant amount of space.
     *
     * @param x the integer to be checked
     * @return true if x is a palindrome, false otherwise
     */
    public boolean isPalindrome(int x) {
        if (x<0 || (x%10==0 && x!=0)) return false;
        int reversed = 0;
        while (x > reversed){
            reversed = reversed * 10 + x % 10;
            x/= 10;
        }
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        ex0009 myo = new ex0009();
        myo.isPalindrome(121);
    }
}
