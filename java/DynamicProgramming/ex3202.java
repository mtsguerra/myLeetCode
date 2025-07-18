class ex3202 {
    /**
     * This method calculates the maximum length of a subsequence of numbers
     * where the sum of any two adjacent numbers in the subsequence is
     * divisible by k.
     *
     * Time Complexity: O(n * k) where n is the length of the array and k
     * is the divisor.
     * Space Complexity: O(k^2) for the dp array (matrix).
     *
     * @param nums An array of integers
     * @param k An integer divisor
     * @return The maximum length of the subsequence
     */
    public int maximumLength(int[] nums, int k) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] %= k;
        }
        int[][] dp = new int[k][k];
        for (int currentNum : nums) {
            for (int j = 0; j < k; j++) {
                dp[currentNum][j] = dp[j][currentNum] + 1;
                maxLength = Math.max(maxLength, dp[currentNum][j]);
            }
        }
        return maxLength;
    }

    /*

    This is a brute force solution that checks all possible pairs of numbers

    public int maximumLength(int[] nums, int k) {
        int maxLength = 0;
        for (int i = 0; i < nums.length-maxLength; i++) {
            int startingNum = nums[i];
            HashSet<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int currentLength = 2;
                int lastNum = nums[j];
                int parity = (startingNum + lastNum) % k;
                if (!seen.contains(parity)) {
                    for (int l = j+1; l < nums.length; l++) {
                        if ((nums[l] + lastNum) % k == parity) {
                            currentLength++;
                            lastNum = nums[l];
                        }
                        if (currentLength + nums.length - l <= maxLength) {
                            break;
                        }
                    }
                }
                seen.add(parity);
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
     */

    public static void main(String[] args) {
        int[] nums = {6,14,14,6,13,1,15,8,1};
        int k = 9;
        ex3202 myo = new ex3202();
        System.out.println(myo.maximumLength(nums, k)); // Expected output: 4
    }
}