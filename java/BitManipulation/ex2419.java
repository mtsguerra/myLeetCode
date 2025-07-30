class ex2419{

    /**
     * Given an integer array nums, return the length of the longest subarray
     * with the maximum bitwise AND (The bitwise AND of an array is the
     * bitwise AND of all the numbers in it.)
     * Approach:
     * For the maximum bitwise AND, we only need to consider the sequence of
     * the maximum number in the array. The longest subarray with equal max and min
     *
     * Time Complexity: O(n) where n is the length of the array.
     * Space Complexity: O(1) for storing the maximum value and sequence length.
     *
     * @param nums an array of integers
     * @return the length of the longest subarray with equal max and min
     */
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxSequence = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                boolean bigger = nums[i] > max;
                max = nums[i];
                int currentSequence = 1;
                int j = i + 1;
                while (j < nums.length && nums[j] == max) {
                    currentSequence++;
                    j++;
                }
                if (bigger) maxSequence = currentSequence;
                else maxSequence = Math.max(maxSequence, currentSequence);
                i = j - 1;
            }
        }
        return maxSequence;
    }
}