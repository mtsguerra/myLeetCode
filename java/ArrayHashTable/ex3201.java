public class ex3201 {

    /**
     * This method calculates the maximum length of a subsequence of numbers
     * where the parity (even or odd) of the numbers alternates.
     *
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(1) for the counters
     *
     * @param nums An array of integers
     * @return The maximum length of the alternating subsequence
     */
    public int maximumLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int nEven=0;
        int nOdd=0;
        int altSeq = 1;
        int last = nums[0];
        if (nums[0]%2==0) nEven++;
        else nOdd++;
        // no need to check the alternating sequence for both even and odd,
        // because for the largest alternating sequence, the first number
        // will always determine the parity of the sequence
        for (int i=1;i<nums.length;i++){
            if (nums[i]%2==0) nEven++;
            else nOdd++;
            if (nums[i]%2!=last%2){
                altSeq++;
                last = nums[i];
            }
        }
        return Math.max(Math.max(nOdd,nEven), altSeq);
    }

    public static void main(String[] args) {
        int[] s = {1,2,1,1,2,1,2};
        ex3201 myo = new ex3201();
        System.out.println(myo.maximumLength(s));
    }
}