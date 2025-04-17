import java.util.*;

class ex2176 {
    /**
     * Given an integer array nums and an integer k, return the number of pairs (i, j) such that:
     * 1. 0 <= i < j < nums.length
     * 2. nums[i] == nums[j]
     * 3. (i * j) % k == 0
     *
     * Time complexity: O(n^2) where n is the length of the array nums.
     * Space complexity: O(1) since we are using a constant amount of space.
     *
     * @param nums the input array
     * @param k the divisor
     * @return the number of valid pairs
     */
    public int countPairs(int[] nums, int k) {
        int ans =0;
        if (nums.length < 2) return ans;
        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i] == nums[j] && (i*j)%k==0){
                    ans++;
                }
            }
        }
        return ans;
    }
}