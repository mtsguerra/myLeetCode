import java.util.*;

class ex2438{

    final static int MOD = 1000000007;

    /**
     * Given an integer n, return the product of all the powers of 2 that can
     * be formed by the bits set in n, for each query in queries.
     *
     * Time Complexity: O(q * k), where q is the number of queries and k is
     * the number of bits set in n.
     * Space Complexity: O(k) for storing powers of 2.
     *
     * @param n The integer whose bits are used to form powers of 2.
     * @param queries An array of queries, each containing two indices [left, right].
     * @return An array containing the product of powers of 2 for each query.
     */
    public int[] productQueries(int n, int[][] queries) {
        int size = Integer.bitCount(n);
        long[] powers = new long[size];

        int currentPower = 1;
        int index = 0;

        while (n>0) {
            if ((n & 1) == 1) {
                powers[index++] = currentPower;
            }
            currentPower <<= 1;
            n >>= 1;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long product = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                product = product * powers[j] % MOD;
            }
            result[i] = (int) (product % MOD + MOD) % MOD;
        }
        return result;
    }
    public static void main(String[] args) {
        ex2438 solution = new ex2438();
        int n = 15;
        int[][] queries = {{0,1},{2,2},{0,3}};
        int[] result = solution.productQueries(n, queries);
        System.out.println(Arrays.toString(result)); // Output: [6, 12, 24]
    }
}