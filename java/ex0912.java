class ex0912 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        mergeSort(nums);
        return nums;
    }
    private void mergeSort(int[] nums){
        if (nums.length<=1) return;
        int mid = nums.length/2;
        int[] left = new int[mid];
        int[] right = new int[nums.length-mid];
        for (int i=0;i<mid;i++){
            left[i] = nums[i];
        }
        for (int j=mid;j<nums.length;j++){
            right[j-mid] = nums[j];
        }
        mergeSort(left);
        mergeSort(right);
        merge(nums,left,right);
    }
    private void merge(int[]nums, int[]left, int[]right){
        int i=0;
        int j=0;
        int k=0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            }
            else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            nums[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }

}