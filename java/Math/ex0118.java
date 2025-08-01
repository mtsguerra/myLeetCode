import java.util.*;

class ex0118 {
    /**
     * Generates the first numRows of Pascal's triangle.
     * Each row i contains the binomial coefficients C(i, j) for j = 0 to i.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2) for storing the triangle
     *
     * @param numRows Number of rows in Pascal's triangle to generate
     * @return A list of lists representing the first numRows of Pascal's triangle
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(calculateFactorial(i, j));
            }
            triangle.add(row);
        }
        return triangle;
    }

    private int calculateFactorial (int n, int k) {
        if (k == 0 || k == n) return 1;
        return calculateFactorial(n - 1, k - 1) * n / k;
    }
}