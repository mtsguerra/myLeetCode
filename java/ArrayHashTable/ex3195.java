import java.util.*;

class ex3195{
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