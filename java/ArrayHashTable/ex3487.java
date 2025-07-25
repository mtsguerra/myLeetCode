import java.util.*;

class ex3487 {

    /**
     * Given an array of integers, this method calculates the maximum sum of
     * unique integers in the array. Only possible to use array for the
     * elements vary from 1 to 100.
     *
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(1), as we are using a fixed-size boolean array.
     *
     * @param nums an array of integers
     * @return the maximum sum of unique positive integers or the highest number if no positives exist
     */
    public int maxSum(int[] nums) {
        int highestNum = Integer.MIN_VALUE;
        boolean[] seen = new boolean[101];
        int sum = 0;
        for (int num : nums) {
            if (num > 0 && !seen[num]) {
                seen[num] = true;
                sum += num;
            }
            highestNum = Math.max(highestNum, num);
        }
        if (sum > 0) return sum;
        return highestNum;
    }

    /*
    public int maxSum(int[] nums) {
        if (nums.length == 1) return nums[0];
        HashSet<Integer> seen = new HashSet<>();
        PriorityQueue<Integer> lowestNumbers = new PriorityQueue<>(Comparator.reverseOrder());
        int maxSum = 0;
        for (int num : nums) {
            lowestNumbers.add(num);
            if (num > 0 && !seen.contains(num)) {
                seen.add(num);
                maxSum += num;
            }
        }
        if (seen.isEmpty()) return lowestNumbers.poll();
        return maxSum;
    }*/
}