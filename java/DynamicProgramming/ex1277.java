import java.util.*;

class ex1277{
    /**
     * Given a m x n binary matrix filled with 0's and 1's, return the number of square submatrices with all ones.
     * A square submatrix is a submatrix that has the same number of rows and columns.
     *
     * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix.
     * Space Complexity: O(m * n) for the dp array.
     *
     * @param matrix a binary matrix
     * @return the number of square submatrices with all ones
     */
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        // store the size of the largest square ending at (i, j)
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                                Math.min(dp[i - 1][j], dp[i][j - 1]));
                    }
                    count += dp[i][j];
                }
            }
        }
        return count;
    }
}