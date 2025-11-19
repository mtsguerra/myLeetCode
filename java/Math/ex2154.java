import java.util.*;

class ex2154 {
    /**
     * Find the final value after doubling original if it exists in nums
     *
     * @param nums array of integers
     * @param original the original integer
     * @return the final value after doubling
     */
    public int findFinalValue(int[] nums, int original) {
        boolean[] set = new boolean[1001];
        for (int num : nums){
            set[num] = true;
        }
        while (original < 1001 && set[original]){
            original *= 2;
        }
        return original;
    }
}