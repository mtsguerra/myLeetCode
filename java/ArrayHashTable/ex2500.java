import java.util.Arrays;

class ex2500{
    /**
     * Deletes the greatest value from each row and returns the greatest
     * value of those removed and accumulate it with +.
     *
     * Time Complexity : O(m*n*log(n)), m->rows, n->cols.
     * Space Complexity : O(1) only using arrays
     *
     * @param grid the @D integer grid to process it
     * @return the sum of the maximum values removed
     */
    public int deleteGreatestValue(int[][] grid) {
        int ans = 0;
        for (int i=0;i<grid.length;i++){
            Arrays.sort(grid[i]);
        }
        for (int i=grid[0].length-1;i>=0;i--){
            int crr = 0;
            for (int j=0;j<grid.length;j++){
                crr=Math.max(crr,grid[i][j]);
            }
            ans += crr;
        }
        return ans;
    }
}