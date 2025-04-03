class ex509{
    /**
     * The Fibonacci number is defined as:
     * F(0) = 0
     * F(1) = 1
     * F(n) = F(n-1) + F(n-2) for n > 1
     *
     * Approach:
     * 1. Initialize two variables to store the previous two Fibonacci numbers.
     * 2. Use a loop to calculate the Fibonacci number iteratively.
     *
     * Time complexity: O(n) where n is the input number.
     * Space complexity: O(1) since we are using a constant amount of space.
     *
     * @param n the input number
     * @return the nth Fibonacci number
     */
    public int fib(int n) {
        if (n<=1) return n;
        int prev = 0;
        int crr = 1;
        for (int i=2;i<=n;i++){
            int next = prev + crr;
            prev = crr;
            crr = next;
        }
        return crr;
    }
}