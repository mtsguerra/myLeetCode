import java.util.*;

class ex3000{
    /**
     * You are given a 2D integer array dimensions where dimensions[i] =
     * [width, height] represents the dimensions of the ith rectangular box.
     * The diagonal of a rectangular box is the segment connecting two
     * opposite corners of the box. The length of this diagonal can be
     * calculated using the formula: diagonal = sqrt(width^2 + height^2).
     * Return the area of the box with the largest diagonal. If there are
     * multiple boxes with the same largest diagonal, return the area of the
     * one with the largest area among them.
     *
     * Time Complexity: O(n), where n is the number of boxes in the input array.
     * Space Complexity: O(1), as we are using only a constant amount of extra space.
     *
     * @param dimensions a 2D integer array representing the dimensions of the boxes
     * @return the area of the box with the largest diagonal (and largest area among them if there are ties)
     */
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        double maxDiagonal = -1;
        for (int[] dim : dimensions) {
            double currentDiagonal = Math.sqrt(dim[0] * dim[0] + dim[1] * dim[1]);
            if (currentDiagonal > maxDiagonal) {
                maxDiagonal = currentDiagonal;
                maxArea = dim[0] * dim[1];
            }
            else if (currentDiagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, dim[0]*dim[1]);
            }
        }
        return maxArea;
    }
}