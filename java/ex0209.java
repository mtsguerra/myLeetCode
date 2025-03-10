public class ex0209 {

    public int minSubArrayLen(int target, int[] numbers){
        // initialize the current sum that will be sliding with the sub array
        int currentSum =0;
        // initialize the minSize as the biggest value
        int minSize = Integer.MAX_VALUE;
        // initialize the start of the sub array, sliding window tec
        int left = 0;
        // iterate through the end of numbers
        // right being the other extreme of the sub array
        for (int right =0;right<numbers.length;right++){
            // increases the current sum
            currentSum+=numbers[right];
            // if the currentSum finally gets to the target or more
            while (currentSum >= target){
                // gets the min size, with the current size being right-left+1
                minSize = Math.min(minSize, right-left+1);
                // removes the first element of the sub array from the sum
                currentSum -= numbers[left];
                // moves the start of the sub array +1
                left++;
            }
        }
        // handles the case where the sum cannot be obtained through the array
        return minSize==Integer.MAX_VALUE ? 0 : minSize;
    }

/* 
    public int minSubArrayLen(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;   
        int currentSum = 0;
        int left =0;
        for (int right=0;right<nums.length;right++){
            currentSum+=nums[right];
            while (currentSum >= target){
                minSize = Math.min(minSize, right-left+1);
                currentSum-=nums[left];
                left++;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
  */  
    public static void main(String[] args) {
        int [] s = {5,1,3,5,10,7,4,9,2,8};
        ex0209 myo = new ex0209();
        System.out.println(myo.minSubArrayLen(15, s));
    }
}
