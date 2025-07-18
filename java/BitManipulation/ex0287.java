import java.util.BitSet;

public class ex0287 {
    // this way we have for sure that all the numbers are between the size of the array
    // and all positive
    public int findDuplicate2 (int[] nums){
        for (int n : nums){
            // if the number at that index is negative that means it was changed before
            // which means that number already was on the array  
            if (nums[Math.abs(n)] < 0) return Math.abs(n);
            // else changes the number on the n index of the array to negative
            else nums[Math.abs(n)] *= -1;
        }
        return -1;
    }
    public int findDuplicate(int[] nums) {
        // create a bitset to track all the seen numbers, bitset is used to avoid overflow
        BitSet bitMask = new BitSet();
        for (int n : nums){
            // get(n) return the boolean of that bit, checking if it is already set
            if (bitMask.get(n)) return n;
            // if its false it means the number was not set before
            // so now i need to check it as true
            bitMask.set(n);
        }
        // no duplicate found
        return -1;
    }
}
