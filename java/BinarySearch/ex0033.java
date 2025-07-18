public class ex0033 {

    //----------------------------------------------------------------//
    // in this order one that is more understandable i iterate through the nums, using 
    // the standard way to use bs, now using the middle term, i will compare it to the
    // left term, in the case he is greater or equal to it, that means that segment is 
    // in order, now on the segment we will compare again the left with the target, if
    // the target is greater or equal to the target that means he could be on the ordered segment,
    // to make sure he is in the segment we need him to be smaller than the middle term,
    // now if he checks this condition we will proceed normally with the bs, in the case he
    // does not checks we will move the left instead, and proceed to keep making this

    public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (right >= left){
            int mid = (right+left) /2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]){
                if (nums[left] <= target && target < nums[mid]){
                    right = mid -1;
                }
                else {
                    left = mid + 1; 
                }
            }
            else{
                if (nums[right] >= target && target > nums[mid]){
                    left = mid + 1;
                }
                else right = mid - 1;
            }
            
        }
        return -1;
    }


    //--------------------------------------------------------------//
    // in this try i would first try some base cases, after that i will create two
    // while loops that depends on two cases, 1 the target being between the second 
    // range defined by if the first element of the first range is greater than the target,
    // the other case being that the target its in the first range, defined by if the last
    // element of the second range is smaller than the target, in those loops i will try to
    // get the left pointer or right pointer till a nums[pointer] where the condition, 
    // nums[left] being smaller than the target or nums[right] being greater than the target
    // if i cant do this that means the number is not on the sequence, and after getting those
    // two pointers to match the condition of the original binary search tree i proceed to do
    // the normal bs

    /*public int search(int[] nums, int target) {

        if (nums.length == 1){
            if (nums[0] == target) return 0;
            else return -1;
        } 
        int right = nums.length-1;
        int left =0;
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
       

        if (nums[left] > target){
            while (nums[left] > target){
                int mid = (right+left) / 2;
                int current = nums[mid];
                if (current > target){
                    left++;
                }
                else if (current < target){
                    left = mid + 1;
                }
                else return mid;
                if (left >= nums.length || right >= nums.length || left < 0 || right < 0) return -1;
            }
        }

        else{
            while (nums[right] < target){
                int mid = right / 2;
                int current = nums[mid];
                if (current < target){
                    right--;
                }
                else if (current > target){
                    right = mid-1;
                }
                else return mid;
                if (left >= nums.length || right >= nums.length || left < 0 || right < 0) return -1;
            }  
        }

        while (right >= left){
            int mid = (right + left) / 2;
            int current = nums[mid];
            if (current == target) return mid;
            else if (current > target){
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }

        return -1;
    }/* */
    public static void main(String[] args) {
        ex0033 myo = new ex0033();
        int[] ns = {4,5,6,7,8,1,2,3};
        int n = myo.search(ns, 8);
        System.out.println(n);
    }
}
