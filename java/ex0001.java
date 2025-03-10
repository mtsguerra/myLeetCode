import java.util.HashMap;
import java.util.Scanner;

public class ex0001 {

    //--------------------------------------------------------------------//
    // in this one to buff the efficiency of this code i will be using a hashMap so i can
    // store the current number and the position where it is, so while iterating through 
    // the array i will be creating a new target that will be the complement to the current
    // number so that the sum of both can result on the target, and check if this new target
    // is present on the hashSet, in the case it is present i will be returning the current index
    // and the value of the key==new target, where value = index of the complement, where
    // it will always be in order so just return it will solve the problem

    static Scanner input = new Scanner(System.in);

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int newTarget = target - nums[i];
            if (map.containsKey(newTarget)) return new int[]{map.get(newTarget), i};
            map.put(nums[i], i);
        }
        return null;
    }

    public void read(){
        String s = input.nextLine();
    }
    public static void main(String[] args) {
        ex0001 myo = new ex0001();
        myo.read();
    }

    //--------------------------------------------------------------------//
}
