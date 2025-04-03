public class ex0011 {

    /**
     * Given n non-negative integers in an array height representing the
     * height of a vertical line drawn at x = i, find two lines,
     * which together result in the maximum area.
     *
     * Approach:
     * 1. Initialize two pointers, one at the beginning and one at the end
     * of the array.
     * 2. Calculate the area formed by the lines at these two pointers.
     * 3. Move the pointer pointing to the shorter line towards the other pointer.
     * 4. Repeat steps 2 and 3 until the two pointers meet.
     *
     * Time complexity: O(n) where n is the number of elements in the array.
     * Space complexity: O(1) since we are using a constant amount of space.
     *
     * @param height the array of heights
     * @return the maximum area
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left =0;
        int right = height.length-1;
        while (left < right){
            int currentArea = Math.min(height[left], height[right]) * (right-left);
            maxArea = Math.max(maxArea, currentArea);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

}
