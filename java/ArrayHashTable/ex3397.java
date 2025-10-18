import java.util.*;

class ex3397{
    /**
     * Finds the maximum number of distinct elements that can be formed
     * from the given array 'nums' by adjusting each element within the range
     * defined by 'k'. Each element can be increased or decreased by up to 'k
     * units to create distinct values.
     *
     * Time Complexity: O(n log n) due to sorting the input array
     * Space Complexity: O(1) as no additional space is used that grows with input
     *
     * @param nums The input array of integers
     * @param k The maximum adjustment allowed for each element
     * @return The maximum number of distinct elements that can be formed
     */
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long next = Long.MIN_VALUE / 4;
        int count = 0;
        for (int num : nums){
            long floor = num - k;
            long ceiling = num + k;
            long current = Math.max(floor, next);
            if (current <= ceiling){
                count++;
                next = current + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ex3397 myo = new ex3397();
        int[] n = {4,4,4,4};
        int k = 1;
        System.out.println(myo.maxDistinctElements(n,k));
    }
}