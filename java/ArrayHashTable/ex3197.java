import java.util.*;

class ex3197{
    /**
     * Given a binary grid, return the area of the smallest axis-aligned rectangle that can enclose all the 1's in the grid
     * after partitioning the grid into three non-overlapping rectangles.
     * The rectangles must cover all the 1's in the grid, and each rectangle must contain at least one 1.
     *
     * Logic behind it: So basically we can divide the grid into 3 parts
     * using 2 lines either horizontal or vertical. Then we can find the minimum area
     * of the rectangle that can enclose all the 1's in each part and sum them up.
     * Rotate works because if we draw 2 horizontal lines, it is equivalent
     * to drawing 2 vertical lines on the rotated grid. And with that we can
     * calculate all the possible 6 ways to divide the grid,
     * 1. 2 horizontal lines
     * 2. 2 vertical lines
     * 3. 1 horizontal line and 1 vertical line (top horizontal)
     * 4. 1 horizontal line and 1 vertical line (bottom horizontal)
     * 5. 1 vertical line and 1 horizontal line (left vertical)
     * 6. 1 vertical line and 1 horizontal line (right vertical)
     *
     * Time Complexity: O(m^2 * n^2), where m is the number of rows and n is the number of columns in the grid.
     * Space Complexity: O(m * n) for the rotated grid.
     *
     * @param grid a binary grid
     * @return the area of the smallest axis-aligned rectangle that can enclose all the 1's in the grid
     */
    public int minimumSum(int[][] grid) {
        int[][] newGrid = rotate(grid);
        return Math.min(call(grid), call(newGrid));
    }
    public int minSum(int[][] grid, int u, int d, int l, int r){
        int minY = grid.length, maxY = 0;
        int minX = grid[0].length, maxX = 0;
        for (int i = u; i <= d; i++) {
            for (int j = l; j <= r; j++) {
                if (grid[i][j] == 1) {
                    minY = Math.min(minY, i);
                    maxY = Math.max(maxY, i);
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j);
                }
            }
        }
        return minY <= maxY ? (maxY - minY + 1) * (maxX - minX + 1) :
                Integer.MAX_VALUE / 3;
    }
    private int[][] rotate (int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] newGrid = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newGrid[m - j - 1][i] = grid[i][j];
            }
        }
        return newGrid;
    }

    private int call(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int ans = n*m;
        for (int i = 0; i + 1 < n; i++) {
            for (int j = 0; j + 1 < m; j++) {
                ans = Math.min(
                        ans,
                        minSum(grid, 0, i, 0, m-1) +
                        minSum(grid, i+1, n-1, 0, j) +
                        minSum(grid, i+1, n-1, j+1, m-1));
                ans = Math.min(
                        ans,
                        minSum(grid, 0, i, 0, j) +
                        minSum(grid, 0, i, j+1, m-1) +
                        minSum(grid, i+1, n-1, 0, m-1));
            }
        }
        for (int i = 0; i + 2 < n; i++) {
            for (int j = i+1; j + 1 < n; j++) {
                ans = Math.min(
                        ans,
                        minSum(grid, 0, i, 0, m-1) +
                        minSum(grid, i+1, j, 0, m-1) +
                        minSum(grid, j+1, n-1, 0, m-1
                        ));
            }
        }
        return ans;
    }
}