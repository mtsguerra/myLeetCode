import java.util.*;

class ex3349{
    /*
    * Determines if there exist two increasing subarrays of length 'k' in
    * the given list of integers. An increasing subarray is defined as a
    * contiguous sequence of elements where each element is strictly greater
    * than the previous one.
    *
    * Time Complexity: O(n^2) in the worst case where n is the size of the input list
    * Space Complexity: O(1) as no additional space is used that grows with input
    *
    * @param nums The list of integers to be checked for increasing subarrays
    * @param k The length of the increasing subarrays to be found
    * @return True if there exist two increasing subarrays of length 'k', otherwise false
    */
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if (k==1) return nums.size()>=2;
        int start = 0;
        for (int end=1; end<nums.size(); end++){
            if (nums.get(end) > nums.get(end-1)){
                if (end - start + 1 == k && end + k < nums.size()){
                    boolean flag = true;
                    for (int i=end+1; i<end+k; i++){
                        if (nums.get(i+1) <= nums.get(i)){
                            flag = false;
                            break;
                        }
                    }
                    if (flag) return true;
                    start++;
                }
            } else {
                start = end;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ex3349 myo = new ex3349();
        List<Integer> n = Arrays.asList(-15,3,16,0);
        System.out.println(myo.hasIncreasingSubarrays(n, 2));
    }
}