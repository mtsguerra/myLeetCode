import java.util.*;

class ex0498{
    /**
     * Given an m x n matrix mat, return an array of all the elements of the
     * array in a diagonal order.
     *
     * Time Complexity: O(m * n), where m is the number of rows and n is the
     * number of columns in the matrix.
     * Space Complexity: O(1), as we are using only a constant amount of
     * extra space for the result array.
     *
     * @param mat an m x n matrix
     * @return an array of all the elements of the matrix in a diagonal order
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int[] result = new int[mat.length * mat[0].length];
        int index = 0;
        for (int d = 0; d < mat.length + mat[0].length; d++) {
            if (d % 2 == 0) {
                int r = Math.min(d, mat.length - 1);
                int c = d - r;
                while (c >= 0 && c < mat[0].length && r >= 0 && r < mat.length) {
                    result[index++] = mat[r--][c++];
                }
            }
            else {
                int c = Math.min(d, mat[0].length - 1);
                int r = d - c;
                while (r >= 0 && r < mat.length && c >= 0 && c < mat[0].length) {
                    result[index++] = mat[r++][c--];
                }
            }
        }
        return result;
    }
}