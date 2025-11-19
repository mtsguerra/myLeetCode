import java.util.*;

class ex2154 {
    public int findFinalValue(int[] nums, int original) {
        boolean[] set = new boolean[1001];
        for (int num : nums){
            set[num] = true;
        }
        while (original < 1001 && set[original]){
            original *= 2;
        }
        return original;
    }
}