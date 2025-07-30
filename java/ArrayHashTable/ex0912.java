import java.util.Arrays;

class ex0912 {
    /**
     * Given an integer array nums, sort the array in ascending order and return it.
     * This implementation uses the merge sort algorithm, but can be done
     * with built-in Arrays.sort() in lower time.
     *
     * Time Complexity: O(n log n) where n is the number of elements in the array.
     * Space Complexity: O(n) for the temporary arrays used in merging.
     *
     * @param nums Array of integers to be sorted
     * @return Sorted array of integers
     */
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        mergeSort(nums);
        return nums;
        // Arrays.sort(nums);
        // return nums;
    }

    private void mergeSort(int[] nums) {
        if (nums.length <= 1) return;
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        mergeSort(left);
        mergeSort(right);
        Merge(nums, left, right);
    }

    private void Merge(int[] nums, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else {
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

    /*
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
    */
}