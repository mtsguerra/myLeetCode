public class ex0035 {

    //----------------------------------------------------------//
    // to find the index where the num should be inserted, i used a binary search method,
    // using a tracker to the left, right indexes, and while the right being greater and
    // equal to the left we keep searching, the mid term is find with the half of the sum
    // of both, and now we utilize the mid term to find the target, with the nums[mid]==t
    // we return the mid index, else if nums[mid] > target, that means that we need to only
    // search the left size of this current interval [l,r] so we change the right value
    // to mid -1, and else we change the left to mid + 1 until we find the target, if we dont
    // find the target int this while that means that the value is not on the array, so
    // if we will return the left index, because if the r==l, that means two cases, one
    // being the case where nums[r] > target, in that case the index where the target will
    // be inserted would be the (r,l) left, because while in the loop when finding that the
    // nums[r] is greater then the target r would change it to r-1, and in the other case
    // where nums[r] < target, the index would be (r+1,l+1), in which case the loop will
    // alter the l value to l+1

    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r = nums.length -1;
        int mid;
        while (r >= l){
            mid = (r+l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) r = mid-1;
            else l =mid+1;
        }
        return l;
    }

    //----------------------------------------------------------//

    /*public int searchInsert(int[] nums, int target) {
      
        int l = 0;
        int r = nums.length - 1;
        while (l!=r && r > l){
            if (nums[r] < target) return r+1;
            else if (nums[r] == target) return r;
            r--;
            if (nums[l] >= target) return l;
            l++;
        }
        if (l==r){
            if (nums[r] >= target) return r;
            return r+1;
        }
        return l;
    } */
    public static void main(String[] args) {
        ex0035 myo = new ex0035();
        int[]t = {2,3,5,6,9};
        System.out.println(myo.searchInsert(t, 7));
    }
}
