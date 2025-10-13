class ex3005 {
    /**
     * You are given an integer array nums.The frequency of an element is
     * the number of times it appears in the array.
     *
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(1), since the size of the frequency array is fixed (
     *
     * @param nums an integer array
     * @return the number of elements that have the maximum frequency in the
     * array
     */
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];
        int res = 0;
        int biggestSeq = 0;
        for (int n : nums){
            arr[n]++;
            if (arr[n] > biggestSeq){
                biggestSeq = arr[n];
                res = arr[n];
            }
            else if (arr[n] == biggestSeq) {
                res += arr[n];
            }
        }
        return res;
    }
}