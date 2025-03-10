public class ex2270 {
    public int waysToSplitArray(int[] nums) {
        // start it with long to avoid overflow cases
        long totalSum =0;
        // calculate the sum of the whole array
        for (int n : nums) totalSum+=n;
        // variable to store the current sum of the split
        long currentSum =0;
        int result = 0;
        for (int i=0;i<nums.length-1;i++){
            // increases the sum with the current number
            currentSum += nums[i];
            // gets the other part of the split by doing total sum - current sum
            if (currentSum >= totalSum-currentSum) result++;
        }
        return result;
    }
}
