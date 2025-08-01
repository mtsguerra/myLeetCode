class ex1929 {
    /**
     * Given an integer array nums of length n, create an array ans of length 2n
     * with a concatenation of nums with itself.
     *
     * Time Complexity: O(n) where n is the length of the input array.
     * Space Complexity: O(n) for the output array.
     *
     * @param nums Array of integers
     * @return Concatenated array of length 2n
     */
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length*2];
        for (int i=0;i<nums.length;i++){
            ans[i] = nums[i];
            ans[i+nums.length] = nums[i];
        }
        return ans;
    }
}