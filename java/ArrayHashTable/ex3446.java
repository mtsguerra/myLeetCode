import java.util.*;

class ex3446 {
    /**
     * You are given a 0-indexed n x n integer matrix grid. Sort each diagonal in
     * the matrix in ascending order and return the resulting matrix.
     *
     * Time Complexity: O(n^2 log n)
     * Space Complexity: O(n)
     *
     * @param grid the input matrix
     * @return the sorted matrix
     */
    public int[][] sortMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            PriorityQueue<Integer> sorted = new PriorityQueue<>(Collections.reverseOrder());
            int temp = i;
            for (int j = 0; j < grid[i].length; j++) {
                sorted.add(grid[temp][j]);
                temp++;
                if (temp == grid[i].length) break;
            }
            temp = i;
            for (int j = 0; j < grid[i].length; j++) {
                grid[temp][j] = sorted.poll();
                temp++;
                if (temp == grid[i].length) break;
            }
        }
        for (int i = 1; i < grid.length; i++) {
            PriorityQueue<Integer> sorted = new PriorityQueue<>();
            int temp = 0;
            for (int j = i;j < grid.length; j++){
                sorted.add(grid[temp][j]);
                temp++;
            }
            temp = 0;
            for (int j = i;j < grid.length; j++){
                grid[temp][j] = sorted.poll();
                temp++;
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        ex3446 ex = new ex3446();
        int[][] grid = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 }, { 1, 1, 1, 1 } };
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        int[][] result = ex.sortMatrix(grid);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}