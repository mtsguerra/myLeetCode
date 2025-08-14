import java.util.*;

class ex0026 {
    /**
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
     * The relative order of the elements should be kept the same.
     * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
     * More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
     * It does not matter what you leave beyond the first k elements.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums An integer array sorted in non-decreasing order.
     * @return The number of unique elements in the modified array.
     */
    public int removeDuplicates(int[] nums) {
        int indx = 0;
        // Using a boolean array to track seen numbers
        // Since nums[i] can be in the range [-100, 100], we offset it by 100
        // to use the index of the boolean array.
        boolean[] seen = new boolean[201];
        for (int i=0; i<nums.length;i++){
            if (!seen[nums[i]+100]){
                nums[indx] = nums[i];
                indx++;
                seen[nums[i] + 100] = true;
            }
        }
        return indx;
    }
}