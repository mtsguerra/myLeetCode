import java.util.HashSet;

class ex0217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i:nums){
            if (!set.add(i)) return true;
        }
        return false;
    }
}