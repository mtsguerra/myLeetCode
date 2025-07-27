import java.util.*;

class ex2210{
    /**
     * Counts the number of hill and valley elements in an array.
     * A hill is an element that is greater than its non-equal neighbors, and a
     * valley is an element that is less than its non-equal neighbors.
     * The function skips consecutive duplicate elements to ensure they are
     * not again
     *
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(1), as we are using only a few variables for counting and tracking.
     *
     * @param nums an array of integers
     * @return the count of hill and valley elements in the array
     */
    public int countHillValley(int[] nums) {
        int count = 0;
        int lastLeft = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            int current = nums[i];
            if (current == lastLeft) continue;
            if (current < nums[i - 1]) {
                while (i<nums.length-1 && current == nums[i + 1]) {
                    i++;
                }
                if (current < nums[i + 1]) {
                    count++;
                }
            }
            else if (current > nums[i - 1]) {
                while (i<nums.length-1 && current == nums[i + 1]) {
                    i++;
                }
                if (current > nums[i + 1]) {
                    count++;
                }
            }
            lastLeft = current;
        }
        return count;
    }
}