import java.util.*;

class ex3195{
    /**
     * Given a binary grid, return the area of the smallest axis-aligned rectangle that encloses all the 1's in the grid.
     * If there are no 1's in the grid, return 0.
     *
     * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
     * Space Complexity: O(1), as we are using only a constant amount of extra space.
     *
     * @param grid a binary grid
     * @return the area of the smallest axis-aligned rectangle that encloses all the 1's in the grid
     */
    public int minimumArea(int[][] grid) {
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    minY = Math.min(minY, i);
                    maxY = Math.max(maxY, i);
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j);
                }
            }
        }
        if (minY == Integer.MAX_VALUE) {
            return 0; // No 1's found
        }
        return (maxY - minY + 1) * (maxX - minX + 1);
    }
}