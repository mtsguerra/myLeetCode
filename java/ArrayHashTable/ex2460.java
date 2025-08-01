class ex2460{
    /**
     * Given a zero-based array nums of size n, for each i in the range 0 <= i < n - 1,
     * if nums[i] == nums[i + 1], then nums[i] is set to 2 * nums[i] and nums[i + 1] is set to 0.
     *
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(n) for the output array.
     *
     * @param nums Array of integers
     * @return An array of integers after applying the operations.
     */
    public int[] applyOperations(int[] nums) {
        int[] ans = new  int[nums.length];
        int pos = 0;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]!=0){
                int mult = 1;
                if (nums[i]==nums[i+1]){
                    mult*=2;
                    nums[i+1]=0;
                }
                ans[pos++]=nums[i] * mult;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        ex2460 obj = new ex2460();
        int[] ans = obj.applyOperations(nums);
    }
}