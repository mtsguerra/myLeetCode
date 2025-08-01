import java.util.HashMap;

public class ex0001 {
    /**
     * Finds two numbers in an array that add up to a target value.
     * This method uses a HashMap to store the indices of the numbers
     * and checks if the complement (target - current number) exists in the map.
     *
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(n) for the HashMap
     *
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
