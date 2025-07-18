import java.util.HashSet;

class ex0128{
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums){
            set.add(n);
        }
        int longest = 1;
        for (int n :set){
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