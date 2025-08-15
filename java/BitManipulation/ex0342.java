import java.util.*;

class ex0342{
    /**
     * Determines if a given integer is a power of four.
     * A number is a power of four if it is greater than zero, it must be
     * also a power of two (i.e., it has only one bit set), and the only set bit
     * must be in an even position (i.e., it must be of the form 4^k).
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param n The integer to check
     * @return true if n is a power of four, false otherwise
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n-1)) == 0 && (n & 0x55555555) != 0;
    }
    /*
    // Using recursion
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        return isPower(n);
    }
    private boolean isPower(int n){
        if (n == 1) return true;
        if (n % 4 != 0) return false;
        return isPower(n/4);
    }
     */
}