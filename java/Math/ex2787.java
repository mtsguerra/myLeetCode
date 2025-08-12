import java.util.*;

class ex2787 {

    final int MOD = 1000000007;

    /**
     * Given an integer n and an integer x, this method calculates the number of
     * ways to express n as a sum of powers of integers from 1 to n raised to the power x.
     *
     * Time Complexity: O(n * log(n)) where n is the input number.
     * Space Complexity: O(n) for the dp array.
     *
     * @param n The target sum.
     * @param x The power to which integers are raised.
     * @return The number of ways to express n as a sum of powers of integers raised to x.
     */
    public int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i<= n; i++) {
            int power = (int) Math.pow(i, x);
            if (power > n) break;
            for (int j = n; j >= power; j--) {
                dp[j] = (dp[j] + dp[j-power]) % MOD;
            }
        }
        return (int) dp[n];
    }

    /*
    public int numberOfWays(int n, int x) {
        int maxN = 1;
        while (Math.pow(maxN + 1, x) <= n) {
            maxN++;
        }
        Integer[][] dp = new Integer[n+1][maxN+1];
        return countWays(n,x,maxN, dp);
    }

    private int countWays(int n, int x, int current, Integer[][] dp) {
        if (n == 0) return 1;
        if (n < 0 || current == 0) return 0;
        if (dp[n][current] != null) return dp[n][current];
        int power = (int) Math.pow(current, x);
        int take = 0;
        if (power <= n){
            take = countWays(n - power, x, current - 1, dp);
        }
        int notCounting = countWays(n, x, current - 1, dp);
        return dp[n][current] = (take + notCounting) % 1000000007;
    }*/

    public static void main(String[] args) {
        ex2787 solution = new ex2787();
        int n = 108;
        int x = 1;
        int result = solution.numberOfWays(n, x);
        System.out.println("Number of ways to express " + n + " as a sum of powers of " + x + ": " + result);
    }
}