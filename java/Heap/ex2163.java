import java.util.*;

class ex2163 {

    public long minimumDifference(int[] nums) {
        int n= nums.length/3;

        // for the highest sum
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        long[] highestSum = new long[n+1];

        // for the lowest sum
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

        int index = n;
        long currentSum = 0;
        for (int i=nums.length-1;i>=n;i--){
            if (pqMin.size() < n){
                pqMin.offer(nums[i]);
                currentSum += nums[i];
                if (pqMin.size()!= n) continue;
            }
            else if (nums[i] > pqMin.peek()) {
                currentSum -= pqMin.poll();
                currentSum += nums[i];
                pqMin.offer(nums[i]);
            }
            highestSum[index] = currentSum;
            index--;
        }
        index = 0;
        currentSum = 0;
        long ans = Long.MAX_VALUE;
        for (int i=0;i<nums.length-n;i++){
            if (pqMax.size() < n){
                pqMax.offer(nums[i]);
                currentSum += nums[i];
                if (pqMax.size()!= n) continue;
            }
            else if (nums[i] < pqMax.peek()) {
                currentSum -= pqMax.poll();
                currentSum += nums[i];
                pqMax.offer(nums[i]);
            }
            ans = Math.min(ans, currentSum - highestSum[index]);
            index++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {7,9,5,8,1,3};
        ex2163 myo = new ex2163();
        System.out.println(myo.minimumDifference(nums)); // Expected output: 1
    }
}