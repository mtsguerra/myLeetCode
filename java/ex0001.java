import java.util.HashMap;
import java.util.Scanner;

public class ex0001 {
    /**
     * Finds two numbers in an array that add up to a target value.
     * @param nums nums Array of integers
     * @param target Target value to find
     * @return An array containing the indices of the two numbers that add up to the target value.
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int newTarget = target - nums[i];
            if (map.containsKey(newTarget)) return new int[]{map.get(newTarget), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
