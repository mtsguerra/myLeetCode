import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ex0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
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
    public static void main(String[] args) {
        int[] n = {1,0,-1,0,-2,2};
        ex0018 myo = new ex0018();
        myo.fourSum(n, 0);
    }
}
