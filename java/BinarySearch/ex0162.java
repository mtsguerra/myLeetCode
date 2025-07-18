public class ex0162 {
    public int findPeakElement(int[] nums) {
        // initialize the pointers to keep track of the sub arrays
        int right = nums.length-1;
        int left = 0;
        // iterate through the nums
        while (left < right){ 
            // set mid like this to avoid overflow
            int mid = left + (right-left) / 2;
            // now checking if the number is peak
            // its also said on the problem that if the number its on the edges
            // it means that the non existent next or last is lower than the number
            if (nums[mid] > (mid-1 < 0 ? Integer.MIN_VALUE : nums[mid-1])
            && nums[mid] > (mid+1 >= nums.length ? Integer.MIN_VALUE : nums[mid+1])){
                return mid;
            }
            // in the case of not found it i will be using this logic to make sure
            // that the size i choose exist at least one peak element
            // to do so, i will be choosing the side where the next or last element
            // is greater than the current, thats because even if the nextnext or lastlast
            // element of this side is greater at one point it will or find 
            // one peak element or get to the edges of the array, and in the last case
            // that would mean that the nextnext or lastlast is smaller than the number
            // resulting in one peak number
            else{
                if (nums[mid] < (mid-1 < 0 ? Integer.MIN_VALUE : nums[mid-1])) right = mid-1;
                else left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        ex0162 myo = new ex0162();
        int [] s = {1,2,3,1};
        System.out.println(myo.findPeakElement(s));
    }
}
