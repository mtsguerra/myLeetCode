import java.util.*;

class ex2044{
    /**
     * Given an array of integers nums, return the number of subsets of nums
     * that have the maximum bitwise OR.
     * The bitwise OR of an array is defined as the bitwise OR of all its
     * elements.
     *
     * Time Complexity: O(2^n) where n is the length of the input array.
     * Space Complexity: O(n) for the recursion stack.
     *
     * @param nums Array of integers
     * @return Number of subsets with maximum bitwise OR
     */
}
    public int countMaxOrSubsets(int[] nums) {
        int bitwiseOr = 0;
        for (int num : nums) {
            bitwiseOr |= num;
        }
        boolean[] visited = new boolean[nums.length];
        return countSubsets(nums, 0, 0,0, bitwiseOr, visited);
    }

    private int countSubsets(int[] nums, int index, int currentOr, int targetOr) {
        if (index == nums.length) {
            return currentOr == targetOr ? 1 : 0;
        }
        // Include the current number in the OR calculation
        int include = countSubsets(nums, index + 1, currentOr | nums[index], targetOr);
        // Exclude the current number from the OR calculation
        int exclude = countSubsets(nums, index + 1, currentOr, targetOr);

        return include + exclude;
    }

    /*
    private int countSubsets(int[] nums, int size,
                             int currentIndex, int currentOr,
                             int targetOr, boolean[] visited) {
        if (size == nums.length) {
            return currentOr == targetOr ? 1 : 0;
        }
        int count = 0;
        if (currentOr == targetOr && size > 0) count++;
        for (int i = currentIndex; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                count += countSubsets(nums, size + 1, i,
                        currentOr | nums[i], targetOr, visited);
                visited[i] = false;
            }
        }
        return count;
    }/*

    public static void main(String[] args) {
        ex2044 myo = new ex2044();
        int[] nums = {2,2,2};
        int result = myo.countMaxOrSubsets(nums);
        System.out.println("Number of subsets with max OR: " + result);
    }
}