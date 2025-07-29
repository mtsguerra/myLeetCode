import java.util.*;

class ex2411{

    /**
     * Given an array of integers nums, return an array result where result[i]
     * is the length of the smallest subarray starting at index i such that
     * the bitwise OR is maximized.
     * Approach:
     * 1. Iterate through the array from the end to the start.
     * 2. For each number, update the last seen index of each bit position (0 to 31).
     * 3. For each index, find the farthest index of any bit that is set in the current number.
     *
     * Time Complexity: O(n) where n is the length of nums.
     * Space Complexity: O(1) for storing bit positions.
     *
     * @param nums Array of integers
     * @return Array of lengths of smallest subarrays
     */
    public int[] smallestSubarrays(int[] nums) {
        int [] result = new int[nums.length];
        int [] bitPositions = new int[32];
        Arrays.fill(bitPositions, -1);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    bitPositions[j] = i;
                }
            }
            int farthestIndex = i;
            for (int j = 0; j < 32; j++) {
                farthestIndex = Math.max(farthestIndex, bitPositions[j]);
            }
            result[i] = farthestIndex - i + 1;
        }
        return result;
    }

    /*
    public int[] smallestSubarrays(int[] nums) {
        int[] result = new int[nums.length];
        // Or value, distance to that value
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=nums.length-1; i>=0; i--) {
            int num = nums[i];
            int maxOr = num;
            int minLen = 1;
            HashMap<Integer, Integer> newMap = new HashMap<>();
            newMap.put(num, 1);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int orValue = entry.getKey() | num;
                int distance = entry.getValue() + 1;
                newMap.put(orValue, Math.min(newMap.getOrDefault(orValue, Integer.MAX_VALUE), distance));
                if (orValue > maxOr) {
                    maxOr = orValue;
                    minLen = distance;
                }
                else if (orValue == maxOr) {
                    minLen = Math.min(minLen, distance);
                }
            }
            map = newMap;
            result[i] = minLen;
        }
        return result;
    }*/

    public static void main(String[] args) {
        ex2411 myo = new ex2411();
        int[] nums = {1,0,2,1,3};
        int[] result = myo.smallestSubarrays(nums);
        System.out.println("Smallest subarrays: " + Arrays.toString(result));
    }
}