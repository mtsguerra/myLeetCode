public class ex0034 {

    //-------------------------------------------------------------------------//
    // int this one, i need to find the first and last appearance of an target in the array
    // now we start a normal bs search but instead of returning in the case of finding the
    // the target i will be iterating until right >= left, and then using the right to check
    // if the target is on the array, because while doing this bs, in the moment i find
    // the target present on array i will set the target index as right, and be moving it
    // until the num[middle] is not anymore equals to the target, then i will be testing
    // if the num[right] is equal to the target, if it isnt that means there are no target 
    // in the array, in the case it is i will be looping again on the array, but with right
    // already being set as the last index found, i will be restarting the left to the beginning
    // now on this loop if i find the num[left] i can already return it because it doesnt matter
    // the other n targets that can be find in this range, only the first and last

    public int[] searchRange(int[] nums, int target){
        int[] f = {-1,-1};
        if (nums.length==0) {
            return f;
        }
        int right = nums.length-1;
        int left = 0;
        while (right >= left){
            int middle = (right+left) / 2;
            int current = nums[middle];
            if (current <= target){
                left = middle +1;
            }
            else right = middle -1;
        }
        if (right >= 0 && nums[right] == target){
            f[1] = right;
        }
        else return f;

        left =0;
        while (right >= left){
                if (nums[left] == target){
                    f[0] = left;
                    return f;
                }
            int middle = (right+left) / 2;
            int current = nums[middle];
            if (current >= target){
                right = middle - 1;
            }
            else left = middle +1;
        }
        f[0] = left;
        return f;
    }

    /*public int[] searchRange(int[] nums, int target) {
        int[] f = {-1,-1};
        if (nums.length==0) {
            return f;
        }
        int right = nums.length-1;
        int left = 0;
        int indexFound = -1;
        while (right >= left){
            int middle = (right+left) / 2;
            int current = nums[middle];
            if (current == target) {
                indexFound = middle;
                break;
            }
            else if (current > target){
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        int firstIndex = indexFound;
        int lastIndex = indexFound;
        if (indexFound==-1){
            int [] f = {-1,-1};
            return f;
        }

        for (int i=indexFound;i >=0;i--){
            if (nums[i] == target){
                firstIndex = i;
            }
            else break;
        }
        for (int i=indexFound;i < nums.length;i++){
            if (nums[i] == target){
                lastIndex = i;
            }
            else break;
        }
        int [] f = {firstIndex, lastIndex};
        return f;
    }/* */

    public static void main(String[] args) {
        int[] s = {1,2,2};
        ex0034 myo = new ex0034();
        for (int n : myo.searchRange(s, 2)){
            System.out.println(n);
        }
    }
}
