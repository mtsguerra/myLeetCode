public class ex0494 {

    /*
    find better solution
    //------------------------------------------------//
    
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWaysRecursive(nums, 0, target);
    }
    public int findTargetSumWaysRecursive(int[] nums, int currentIndex, int target){
        if (currentIndex==nums.length){
            return target==0?1:0;
        }
        return findTargetSumWaysRecursive(nums, currentIndex+1, target+nums[currentIndex]) + findTargetSumWaysRecursive(nums, currentIndex+1, target-nums[currentIndex]);
    }

    //-----------------------------------------------//

    public int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        findTargetSumWaysRecursive(nums, 0, target);
        return count;
    }
    public void findTargetSumWaysRecursive(int[] nums, int currentIndex, int target){
        if (currentIndex==nums.length){
            int sum=0;
            for (int n : nums){
                sum+=n;
            }
            if (sum==target) count++;
            return;
        }
        findTargetSumWaysRecursive(nums, currentIndex+1, target);
        nums[currentIndex] = nums[currentIndex] * -1;
        findTargetSumWaysRecursive(nums, currentIndex+1, target);
    }*/
}