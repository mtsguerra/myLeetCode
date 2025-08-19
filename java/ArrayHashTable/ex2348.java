import java.util.*;

class ex2348{
    /**
     * Given an integer array nums, return the number of subarrays filled with 0.
     * A subarray is a contiguous non-empty sequence of elements within an array.
     *
     * Time Complexity: O(n), where n is the length of the input array nums.
     * Space Complexity: O(1), as we are using only a few variables for counting.
     *
     * @param nums an array of integers
     * @return the number of zero-filled subarrays
     */
    public long zeroFilledSubarray(int[] nums) {
        long seq = 0;
        long total = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                total += (seq * (seq + 1)) / 2;
                seq = 0;
            }
            else {
                seq++;
            }
        }
        if (seq > 0) {
            total += (seq * (seq + 1)) / 2;
        }
        return total;
    }
}