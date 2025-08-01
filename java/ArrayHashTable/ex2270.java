public class ex2270 {
    /**
     * Given an integer array nums, return the number of ways you can split
     * the array into two non-empty parts such that the sum of the elements
     * in the first part is greater than or equal to the sum of the elements
     * in the second part.
     *
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(1), as we are using only a few variables for counting and tracking.
     *
     * @param nums an array of integers
     * @return the number of valid splits
     */
    public int waysToSplitArray(int[] nums) {
        long totalSum =0;
        for (int n : nums) totalSum+=n;
        long currentSum =0;
        int result = 0;
        for (int i=0;i<nums.length-1;i++){
            currentSum += nums[i];
            if (currentSum >= totalSum-currentSum) result++;
        }
        return result;
    }
}
