public class ex0268 {

    public int missingNumber(int[] nums){
        int result = nums.length;
        // know the logic but idk how to explain why it works
        for (int i=0;i<nums.length;i++){
            result ^= i ^ nums[i];
        }
        return result;
    }

    /* 
    public int missingNumber(int[] nums) {
        int n = nums.length+1;   
        // gauss sum
        int needed_sum = (n-1) * n / 2;
        int currentSum = 0;
        for (int nn : nums){
            currentSum += nn;
        }
        return needed_sum - currentSum;
    }*/
    public static void main(String[] args) {
        int[] s = {3,0,1};
        ex0268 myo = new ex0268();
        myo.missingNumber(s);
    }
}
