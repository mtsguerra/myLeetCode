import java.util.HashSet;

class ex0217 {
    /**
     * Given an integer array nums, return true if any value appears at least
     * twice in the array, and return false if every element is distinct.
     *
     * Time Complexity: O(n) where n is the length of the input array.
     * Space Complexity: O(n) for storing elements in a HashSet.
     *
     * @param nums Array of integers
     * @return true if there are duplicates, false otherwise
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i:nums){
            if (!set.add(i)) return true;
        }
        return false;
    }
}