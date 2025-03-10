class ex1749 {
    public int maxAbsoluteSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++){
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        int minSoFar = nums[0];
        int minEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++){
            minEndingHere = Math.min(nums[i], minEndingHere + nums[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }
        return Math.max(maxSoFar,Math.abs(minSoFar));
    }

    public static void main(String[] args) {
        ex1749 myo = new ex1749();
        int[] n = {1,-3,2,3,-4};
        System.out.println(myo.maxAbsoluteSum(n));
    }
}