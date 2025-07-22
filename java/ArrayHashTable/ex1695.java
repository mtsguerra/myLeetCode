import java.util.*;

class ex1695 {
    /**
     * Given an array of integers, this method finds the maximum sum of a
     * subarray with all unique elements.
     * It uses a sliding window approach with a HashSet to track unique elements.
     *
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(n), for the HashSet used to track unique elements.
     *
     * @param nums an array of integers
     * @return the maximum sum of a subarray with all unique elements
     */
    public int maximumUniqueSubarray(int[] nums) {
        int start = 0, maxSum = 0, currentSum = 0;
        Set<Integer> seen = new HashSet<>();
        for (int end = 0; end < nums.length; end++) {
            int num = nums[end];
            while (seen.contains(num)) {
                seen.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
            seen.add(num);
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}