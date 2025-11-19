import java.util.*;

class ex1437 {
    /**
     * Check if all 1's in the array are at least k distance apart
     *
     * @param nums array of integers (0s and 1s)
     * @param k minimum distance between 1's
     * @return true if all 1's are at least k distance apart, false otherwise
     */
    public boolean kLengthApart(int[] nums, int k) {
        int lastOneIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastOneIndex != -1 && i - lastOneIndex - 1 < k) {
                    return false;
                }
                lastOneIndex = i;
            }
        }
        return true;
    }
}