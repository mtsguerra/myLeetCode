public class ex0081 {
    public boolean search(int[] nums, int target) {

        // handles the case where theres only one number
        if (nums.length==1) return nums [0] == target;

        // initialize the pointers to keep track of the boundaries
        int left =0;
        int right=nums.length-1;

        // loop until the target is found or the left > right
        // in the second case that would mean the number its not in the list
        while (left <= right){
            // using this sum to make sure it does not overflow
            int mid = (left+(right-left)) / 2;
            if (nums[mid]==target) return true;
            // handles those extreme cases where the first mid and last are equal
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                // it loops until or right or left is not equals to mid anymore
                while (left <= right && nums[left] == nums[mid] && nums[right] == nums[mid]) {
                    left++;
                    right--;
                }
            }
            // these two if are made to find which side is current sorted
            // allocating this array into two new arrays, at least one necessarily is in order

            // case 1: the first half its sorted
            else if (nums[mid] >= nums[left]){
                // this tests if the target its in the range found between left and mid
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                // if it is not in the range that means it is on the other half
                else left = mid + 1;
            }
            else {
                // same logic as the other one
                if (target <= nums[right] && target > nums[mid]) left = mid + 1;
                else right = mid -1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ex0081 myo = new ex0081();
        int[] l = {2,5,6,0,0,1,2};
        System.out.println(myo.search(l, 3));
    }
}
