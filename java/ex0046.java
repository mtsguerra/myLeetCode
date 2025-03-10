import java.util.ArrayList;
import java.util.List;

public class ex0046 {
    // permutation by swapping
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        // using the int start as a way to keep track where to start the swapping
        bt(nums, 0, res);
        return res;
    }
    private void bt (int[]nums, int start, List<List<Integer>> res){
        // when arrive at the max length just add the current nums, as it is swapped
        if (start == nums.length){
            List<Integer> permut = new ArrayList<>();
            for (int n : nums) permut.add(n);
            res.add(permut);
            return;
        }
        for (int i=start;i<nums.length;i++){
            // swap the number at the start with all the remaining ones including himself
            swap(nums, start, i);
            bt(nums, start+1, res);
            // swap back to backtrack it 
            swap(nums, i, start);
        }
    }
    private void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // permutations by creating all
    public List<List<Integer>> permute1(int[] nums) {
        // boolean to keep track where which numbers were used
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> f = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        perm(nums, visited, temp, f);
        return f;

    }

    public void perm(int[] nums, boolean[] visited, List<Integer> current,
    List<List<Integer>> f) {
        if (current.size() == nums.length){
            f.add(new ArrayList<>(current));
            return;
        }
        for (int i=0;i<visited.length;i++){
            // if not used 
            if (!visited[i]){
                current.add(nums[i]);
                visited[i] = true;
                perm(nums, visited, current, f);
                // returns to false and removes it from the current permutation
                // so i can backtrack it
                visited[i] = false;
                current.remove(current.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        ex0046 myo = new ex0046();
        int[]n = {1,2,3};
        myo.permute(n);
    }
}
