import java.util.*;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;


public class ex0018 {

    /**
     * Finds all unique quadruplets in the array that sum to a given target.
     *
     * Approach:
     * 1. Sort the array to enable the two-pointer technique.
     * 2. Iterate through the array, using two nested loops to fix the first two elements.
     * 3. Use two pointers to find pairs that sum to the negative of the sum of the first two elements.
     *
     * Time complexity: O(n^3) where n is the length of the array.
     * Space complexity: O(1) since I am using a constant amount of space.
     *
     * @param nums the input array
     * @param target the target sum
     * @return a list of lists containing the quadruplets that sum to the target
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return new ArrayList<>();
        int size = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0;i<size-3;i++){
            if (i > 0 && nums[i] == nums[i-1]) continue; // skip duplicates
            long first = nums[i];
            for (int j=i+1;j<size-2;j++){
                if (j > i+1 && nums[j] == nums[j-1]) continue; // skip duplicates
                long second = nums[j];
                int left = j+1;
                int right = size-1;
                while (left < right){
                    long sum = nums[left] + nums[right] + first + second;
                    if (sum == target){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left],
                                nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                    else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return ans;
    }

    /*
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        mergeSort(nums);
        HashSet<List<Long>> f = new HashSet<>();
        for (int i=0;i<nums.length-3;i++){
            long fir = nums[i];
            for (int j=i+1;j<nums.length-2;j++){
                long sec = nums[j];
                long ref = target-fir-sec;
                f.addAll(findPair(nums, j+1, ref, fir, sec));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        Iterator<List<Long>> it = f.iterator();
        while (it.hasNext()){
            List<Long> temp = it.next();
            List<Integer> ttt = new ArrayList<>();
            Iterator<Long> ite = temp.iterator();
            while (ite.hasNext()){
                int a = ite.next().intValue();
                ttt.add(a);
            }
            ans.add(ttt);
        }
        return ans;
    }

    private HashSet<List<Long>> findPair (int[] nums, int start, long ref, long fir, long sec){
        HashSet<List<Long>> f = new HashSet<>();
        int left = start;
        int right = nums.length-1;
        while (right > left){
            long currentSum = nums[left] + nums[right];
            if (currentSum == ref) {
                List<Long> temp = List.of(fir, sec,(long)nums[right],(long)nums[left]);
                f.add(temp);
                long l = nums[left];
                long r = nums[right];
                while (right > left && nums[right] == r && nums[left] == l){
                    left++;
                    right--;
                }
            }
            else if (currentSum > ref){
                right--;
            }
            else left++;
        }
        return f;
    }

    public void mergeSort(int[] nums) {
        int sz = nums.length;
        if (sz < 2) return;
        int[] left = new int[sz/2];
        int[] right = new int[sz-sz/2];
        for (int i=0;i<sz/2;i++){
            left[i] = nums[i];
        }
        for (int j =sz/2;j<sz;j++){
            right[j-sz/2] = nums[j];
        }
        mergeSort(left);
        mergeSort(right);

        merge(nums,left,right);
    }
    private void merge(int[]nums,int[]left,int[]right) {
        int i=0;
        int j=0;
        int k=0;
        while (i < left.length && j < right.length){
            if (left[i] <= right[j]){
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



    @Test
    public void testFourSumExample(){
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = fourSum(nums, 0);
        assertTrue(result.contains(Arrays.asList(-2, -1, 1, 2)));
        assertTrue(result.contains(Arrays.asList(-2, 0, 0, 2)));
        assertTrue(result.contains(Arrays.asList(-1, 0, 0, 1)));
    }

*/
}
