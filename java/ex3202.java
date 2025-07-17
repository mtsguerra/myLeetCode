import java.util.*;

class ex3202 {
    public int maximumLength(int[] nums, int k) {
        int maxLength = 0;
        for (int i = 0; i < nums.length-maxLength; i++) {
            int startingNum = nums[i];
            HashSet<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int currentLength = 2;
                int lastNum = nums[j];
                int parity = (startingNum + lastNum) % k;
                if (!seen.contains(parity)) {
                    for (int l = j+1; l < nums.length; l++) {
                        if ((nums[l] + lastNum) % k == parity) {
                            currentLength++;
                            lastNum = nums[l];
                        }
                        if (currentLength + nums.length - l <= maxLength) {
                            break;
                        }
                    }
                }
                seen.add(parity);
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {6,14,14,6,13,1,15,8,1};
        int k = 9;
        ex3202 myo = new ex3202();
        System.out.println(myo.maximumLength(nums, k)); // Expected output: 4
    }
}