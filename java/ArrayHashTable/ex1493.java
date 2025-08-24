import java.util.*;

class ex1493{
    /**
     * Given a binary array nums, you should delete one element from it.
     * Return the size of the longest non-empty subarray containing only 1's in the resulting array.
     * Return 0 if there is no such subarray.
     *
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(1), as we are using only a constant amount of extra space.
     *
     * @param nums a binary array
     * @return the size of the longest non-empty subarray containing only 1's after deleting one element
     */
    public int longestSubarray(int[] nums) {
        int seq = 0, maxSeq = 0;
        int eliminated = -1;
        for (int right=0;right < nums.length;right++){
            if (nums[right] == 1) seq++;
            else {
                if (eliminated == -1) {
                    eliminated = right;
                }
                else {
                    maxSeq = Math.max(maxSeq, seq);
                    seq = right - eliminated - 1;
                    eliminated = right;
                }
            }
        }
        return Math.max(maxSeq, seq) - (eliminated == -1 ? 1 : 0);
    }
}