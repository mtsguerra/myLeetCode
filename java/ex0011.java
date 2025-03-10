public class ex0011 {

    //-----------------------------------------------------------------------------//
    // in this exercise i will be using a right pointer and a left pointer to keep track
    // of both edges of the array, and iterate until one equals another or else, now on
    // the loop i will be getting the currentArea by using minHeight and the distance between them
    // and where the lowest height lies i will be advancing one index, in this way we can be 
    // sure that the biggest height will be use on the next try to find a bigger area

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

    //-----------------------------------------------------------------------------//
}
