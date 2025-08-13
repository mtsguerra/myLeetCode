class ex0326{
    /**
     * Given an integer n, return true if it is a power of three. Otherwise, return false.
     * An integer n is a power of three, if there exists an integer x such that n == 3^x.
     *
     * Time Complexity: O(log n), where n is the input number. The loop runs until n becomes 1.
     * Space Complexity: O(1), since we are using a constant amount of space.
     *
     * @param n The integer to check if it is a power of three
     * @return true if n is a power of three, false otherwise
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0 || (n % 3 != 0 && n !=1)) return false;
        while (n > 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return n == 1;
    }
}