import java.util.Arrays;

public class ex0016 {

    /**
     * Finds the sum of three integers in an array such that the sum is closest to a given target value.
     * If there are multiple possible closest sums, the smallest one is returned.
     * The input array is sorted, and a two-pointer approach with nested iterations is used.
     *
     * Time Complexity: O(n^2) where n is the length of the array
     * Space Complexity: O(1) as the sorting modifies the input array in-place
     *
     * @param nums Array of integers where the closest sum is to be found
     * @param target The target value to which the closest sum is calculated
     * @return The sum of three integers from the input array closest to the target value
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i=0;i<nums.length-2;i++){
            int current = nums[i];
            if (i > 0 && current == nums[i-1]) continue; // Skip duplicates
            int newTarget = target - current;
            int left = i+1;
            int right = nums.length-1;
            int currentClosest = nums[left] + nums[right];
            while (left<right){
                int currentSum = nums[left] + nums[right];
                if (currentSum == newTarget) return target;
                if (currentSum > newTarget){
                    currentClosest = Math.abs(newTarget-currentClosest) > Math.abs(newTarget-currentSum) ? currentSum : currentClosest;
                    right--;
                }
                else {
                    currentClosest = Math.abs(newTarget-currentClosest) > Math.abs(newTarget-currentSum) ? currentSum : currentClosest;
                    left++;
                }
            }
            if (Math.abs(target - (currentClosest+current)) < Math.abs(target - closest)){
                closest = currentClosest + current;
            }
        }
        return closest;
    }

    /*
    public int threeSumClosest1(int[] nums, int target) {
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        mergeSort(nums);
        int closest=target < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
        for (int i=0;i<nums.length-1;i++){
            int n = nums[i];
            int newTarget = target-n;
            int currentClosest = findClosest(nums, target, newTarget, i+1) + n;
            closest = Math.abs(target-closest) > Math.abs(target-currentClosest)  ? currentClosest : closest;
            if (closest==target) return target;
        }
        return closest;
    }
    private int findClosest(int[]nums,int target, int newTarget, int start){
        int end = nums.length-1;
        int closestCompl = newTarget < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
        while (end > start){
            int currentSum = nums[start]+nums[end];
            if (currentSum==newTarget) return currentSum;
            if (currentSum > newTarget){
                closestCompl = Math.abs(newTarget-closestCompl) > Math.abs(newTarget-currentSum) ? currentSum : closestCompl;
                end--;
            }
            else {
                closestCompl = Math.abs(newTarget-closestCompl) > Math.abs(newTarget-currentSum) ? currentSum : closestCompl;
                start++;
            }
            if (closestCompl==newTarget) return newTarget;
        }
        return closestCompl;
    }
    public void mergeSort(int[] nums){
        int len = nums.length;
        if (len <2) return;
        int mid = len/2;
        int[] left = new int[mid];
        int[] right = new int[len-mid];
        for (int i=0;i<mid;i++){
            left[i] = nums[i];
        }
        for (int j=mid;j<len;j++){
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
        while (i < left.length){
            nums[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length){
            nums[k] = right[j];
            j++;
            k++;
        }
    }

     */
    public static void main(String[] args) {
        int[] ns = {1,1,1,1};
        ex0016 myo = new ex0016();
        System.out.println(myo.threeSumClosest(ns, 0));
    }
}
