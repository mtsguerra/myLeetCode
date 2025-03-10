public class ex0153 {
    public int findMin(int[] nums) {
        // handles some base cases
        if (nums.length==0) return -1;
        if (nums.length==1) return nums[0];
        // initialize both pointers to keep track of the current sub array
        int right = nums.length-1;
        int left = 0;
        // checks if the array is currently sorted
        if (nums[left] < nums[right]) return nums[0];
        // iterates until found the minimum or until r==l, extreme case
        while (left<right){
            // sets mid like this to cover overflow
            int mid = left + (right-left) / 2;
            // checks if the the last number is greater than the current
            // if so that means the current is the minimum, cause if you rotates
            // an ordered array that would means that the minimum value would be on the
            // break point between the both arrays
            if (mid > 0 && nums[mid-1] > nums[mid]) return nums[mid];
            // handles the case where the second array is the one that is ordered
            // and because the mid-1 isnt greater that means at least one number on the left
            // array is smaller than the current
            if (nums[right] >= nums[mid]) right = mid-1;
            // same logic
            else if (nums[left] <= nums[mid]) left = mid+1;
        }
        return nums[left];
    }
    public static void main(String[] args) {
        int[] s = {2,1};
        ex0153 myo = new ex0153();
        System.out.println(myo.findMin(s));
    }
}
