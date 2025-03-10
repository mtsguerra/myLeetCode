public class ex0238 {
    public int[] productExceptSelf(int[] nums) {
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
    }

    public static void main(String[] args) {
        ex0238 myo = new ex0238();
        int[] nums = {1,2,3,4};
        System.out.println(myo.productExceptSelf(nums));
    }
}