public class ex0238 {

    /**
     * Given an integer array nums, return an array answer such that
     * answer[i] is equal to the product of all the elements of nums except nums[i].
     *
     * Time Complexity: O(n) where n is the length of the input array.
     * Space Complexity: O(n) for the output array.
     *
     * @param nums Array of integers
     * @return Array of products except self
     */
    public int[] productExceptSelf(int[] nums) {
        int countZero = 0;
        int posZero = -1;
        int product = 1;
        int[] ans = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int num = nums[i];
            if (num==0) {
                if (++countZero > 1) return ans;
                posZero = i;
            }
            else product *= num;
        }
        if (countZero == 1) {
            ans[posZero] = product;
            return ans;
        }
        for (int i=0;i<nums.length;i++){
            ans[i] = product / nums[i];
        }
        return ans;
    }

    /*public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] sumsL = new int[nums.length];
        int[] sumsR = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            sumsL[i] = (i==0)?nums[0]:sumsL[i-1]*nums[i];
            sumsR[nums.length-i-1] = (i==0)?nums[nums.length-1]:sumsR[nums.length-i]*nums[nums.length-i-1];
        }
        ans[0] = sumsR[1];
        ans[nums.length-1] = sumsL[nums.length-2];
        for (int i=1;i<nums.length-1;i++){
            ans[i] = sumsL[i-1]*sumsR[i+1];
        }
        return ans;
    }*/

    public static void main(String[] args) {
        ex0238 myo = new ex0238();
        int[] nums = {1,2,3,4};
        System.out.println(myo.productExceptSelf(nums));
    }
}