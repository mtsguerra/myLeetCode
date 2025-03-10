import java.util.ArrayList;
import java.util.List;

public class ex0015 {
    public List<List<Integer>> threeSum(int[] nums) {
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
