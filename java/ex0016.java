public class ex0016 {
    public int threeSumClosest(int[] nums, int target) {
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
    public static void main(String[] args) {
        int[] ns = {1,1,1,1};
        ex0016 myo = new ex0016();
        System.out.println(myo.threeSumClosest(ns, 0));
    }
}
