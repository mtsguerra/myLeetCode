import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

class ex0128{

    /**
     * Given an unsorted array of integers nums, return the length of the
     * longest consecutive elements sequence.
     *
     * Time Complexity: O(n) where n is the number of elements in the array.
     * Space Complexity: O(n) for storing elements in a HashSet.
     *
     * @param nums Array of integers
     * @return Length of the longest consecutive elements sequence
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums){
            set.add(n);
        }
        int longest = 1;
        for (int n : nums){
            if (!set.contains(n-1)){
                int streak = 1;
                while (set.contains(n+streak)){
                    streak++;
                }
                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }
}