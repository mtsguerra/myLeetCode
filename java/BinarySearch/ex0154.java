public class ex0154 {

    // this solution is not optimized
    public int findMin(int[] nums) {
        // handles the base cases
        if (nums.length==0) return -1;
        if (nums.length==1) return nums[0];
        // initialize the pointers to set boundaries of the sub array
        int right = nums.length-1;
        int left = 0;
        // checks if the array is already sorted
        if (nums[left] < nums[right]) return nums[0];
        // iterates through the array
        while (left<right){
            // initialize the mid like this to avoid overflow
            int mid = left + (right-left) / 2;
            // cases where is found a duplicate
            // case 1. where the left=mid=right
            if (nums[mid] == nums[left] && nums[left] == nums[right]){
                // here i will loop it until left is no longer equals to right
                // or if left >= right, that would means that the whole sequence 
                // is filled with the same number
                // i can check with left==right, because the only way to right==left
                // until the mid its if the whole sequence is filled with the same number
                while (nums[left] == nums[right]){
                    left++;
                    right--;
                    if (left==right || left > right) return nums[mid];
                }
            }
            // case 2. where the mid-1 is equals to mid
            // this means that i can not check the condition to see if the mid is the minimum
            else if (mid > 0 && nums[mid-1] == nums[mid]){
                // so if the mid is lower than the right
                // that means that the minimum is on the second half
                // so i need to decrease the mid until i find different number 
                // or if mid==0
                if (nums[right] > nums[mid]){
                    while (mid > 0 && nums[mid-1] == nums[mid]) mid--;
                }
                // on the other hand if mid is greater than right
                // that would result int the minimum being on the second half 
                // so i need to increase the mid until find a different
                // or until mid == n.len-1
                else while (mid < nums.length-1 && nums[mid+1] == nums[mid]) mid++;
            }
            // now i can check if the currently mid is the minimum,
            // because by having two sorted arrays, product of an original sorted array
            // rotated n times, the minimum value necessarily is on the break
            // point between this both new arrays 
            if (mid > 0 && nums[mid-1] > nums[mid]) return nums[mid];
            // now i check if the right side is sorted, if it is, that means
            // at least one value on the left side is smaller than mid
            if (nums[right] >= nums[mid]) right = mid-1;
            // same logic for the left side
            else if (nums[left] <= nums[mid]) left = mid+1;
        }
        return nums[left];
    }
    public static void main(String[] args) {
        int[] s = {3,0,0,0,0,0,0,0,0,0,3};
        ex0154 myo = new ex0154();
        System.out.println(myo.findMin(s));
    }
}
