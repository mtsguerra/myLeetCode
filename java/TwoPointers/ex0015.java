import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ex0015 {
    /**
     *
     * Finds all unique triplets in the array that sum to zero.
     * Approach:
     * 1. Sort the array to use the two-pointer method.
     * 2. Iterate through the array, using the current element as a reference.
     * 3. Use two pointers to find pairs that sum to the negative of the
     * current element.
     *
     * Time complexity: O(n^2) where n is the length of the array.
     * Space complexity: O(1) since we are using a constant amount of space.
     *
     * @param nums the input array
     * @return a list of the triplets that sum to zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0 ) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int s = nums[right]+nums[left];
                if (s == target) {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                }
                if (s < target) left++;
                else right--;
            }
        }
        return res;
    }

    /**
     * Finds all unique triplets in the array that sum to zero.
     *
     * Approach:
     * 1. Sort the array to use the two-pointer method.
     * 2. Iterate through the array, using the current element as a reference.
     * 3. Use two pointers to find pairs that sum to the negative of the
     * current element.
     *
     * Time complexity: O(n^2) where n is the length of the array.
     * Space complexity: O(1) since we are using a constant amount of space.
     *
     * @param nums the input array
     * @return a list of lists containing the triplets that sum to zero
     */
    public List<List<Integer>> threeSum1(int[] nums){
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            if (nums[i] > 0) break;
            if (i>0&&nums[i]==nums[i-1]) continue;
            int n = nums[i];
            int left=i+1, right=nums.length-1;
            while (left < right){
                int sum = n + nums[left] + nums[right];
                if (sum==0){
                    answer.add(List.of(n, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                else if (sum < 0) left++;
                else right--;
            }
        }
        return answer;
    }

    /*
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> f = new ArrayList<>();
        mergeSort(nums);
        // until nums.length-1 because we do not need to try to find a pair when theres only one remaining number on the sliced list
        for (int i =0; i<nums.length-1;i++) {
            // avoid duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int n = nums[i];
            f.addAll(findPairs(nums, i+1, n*-1, n));
        } 
        return f;
    }
    // sup function to find the others pairs present in the trio using two pointers 
    private List<List<Integer>> findPairs (int[] nums, int start, int target, int initial){
        // start with the i+1 so we only check the remaining numbers on the list, because any possible previous trio was already formed
        List<List<Integer>> f = new ArrayList<>();
        int end = nums.length-1;
        // checks by using two pointers to find a possible sum
        while (end > start) {
            int l = nums[start];
            int r = nums[end];
            int currentSum = l + r;
            if (currentSum==target){
                // creates the temp list to add to the final one
                List<Integer> t = List.of(initial, l, r);
                f.add(t);
                // it iterates until at least one of the numbers is different from the pair found
                // to avoid duplicates
                while (end > start && nums[start] == l && nums[end] == r){
                    start++;
                    end--;
                }
            }
            else if (currentSum > target) end--;
            else start++;
        }
        return f;
    }
    // standard mergeSort
    public void mergeSort (int[] nums) {
        int siz = nums.length;
        if (siz < 2) return;
        int[] left = new int[siz / 2];
        int[] right = new int[siz - siz/2];
        for (int i = 0; i < siz / 2;i++){
            left[i] = nums[i];
        }
        for (int j = siz/2; j < siz;j++){
            right[j-(siz/2)] = nums[j];
        }
        mergeSort(left);
        mergeSort(right);
        merge(nums, left, right);
    }
    private void merge(int[]nums, int[] left, int[] right){
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
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        ex0015 myo = new ex0015();
        for (List<Integer> temp : myo.threeSum(nums)){
            for (int n : temp) {
                System.out.println(n);
            }
        }
    }
}
