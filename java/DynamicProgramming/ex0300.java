import java.util.ArrayList;

public class ex0300 {
    public int lengthOfLIS(int[] nums) {
        ArrayList <Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for (int i=1;i<nums.length;i++){
            if (nums[i] > arr.get(arr.size()-1)) arr.add(nums[i]);
            else{
                int j = bs(arr, nums[i]);
                arr.set(j, nums[i]);
            }
        }
        return arr.size();
    }
    public int bs(ArrayList <Integer> arr, int num){
        int right = arr.size()-1;
        int left=0;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (arr.get(mid)==num) return mid;
            else if (arr.get(mid)>num) right=mid-1;
            else left=mid+1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] s = {0,1,0,3,2,3};
        ex0300 myo = new ex0300();
       System.out.println(myo.lengthOfLIS(s));
    }
}
