import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;

public class ex2342 {
    public int maximumSum(int[] nums) {
        // because the greatest sum of digits possible is 81, considering we need to sum the pair in the end without overflow
        // i create a array to keep track of the biggest number
        // found until then where the sum is equal to
        int[] bg = new int[82];
        int maxSum = Integer.MIN_VALUE;
        // fill the array with min_value
        Arrays.fill(bg, Integer.MIN_VALUE);
        for (int n : nums){
            int temp = n;
            // finds the sum of the digits
            int digitSum = 0;
            while (temp > 0) {
                digitSum+=temp%10;
                temp/=10;
            }
            // if the sum of digits is the first time found subs in
            if (bg[digitSum]==Integer.MIN_VALUE) bg[digitSum] = n;
            // otherwise do the sum of the current biggest and the current number
            else{
                int currentSum = bg[digitSum] + n;
                if (currentSum>maxSum) maxSum=currentSum;
                // in the case of the current number being bigger than the current bigger i sub it in
                bg[digitSum] = n > bg[digitSum] ? n : bg[digitSum];
            }
        }
        // handles the case where theres no pair with the same sum of digits
        return maxSum==Integer.MIN_VALUE ? -1 : maxSum;
    }
    public int maximumSum3(int[] nums) {
        // creates a table to keep track of all the digits sums and their respective numbers the come from
        // as i need only the two greatest numbers i will be using a fixed sized array
        HashMap<Integer, int[]> table = new HashMap<>();
        for (int n : nums) {
            int temp = n;
            int sn = 0;
            // finds the sum of the digits
            while (temp != 0) {
                sn += temp % 10;
                temp/=10;
            }
            // if the table already contains that sum it will update the topTwo in their respective order if possible
            if (table.containsKey(sn)) {
                int[] topTwo = table.get(sn);
                if (n > topTwo[0]){
                    topTwo[1] = topTwo[0];
                    topTwo[0] = n;
                }
                else if(n > topTwo[1]) topTwo[1] = n;
            }
            else {
                table.put(sn, new int[]{n, Integer.MIN_VALUE});
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for (int[] topTwos : table.values()){
            if (topTwos[1] == Integer.MIN_VALUE) continue;
            int currentSum = topTwos[1] + topTwos[0];
            if (currentSum > maxSum) maxSum = currentSum;
        }
        return (maxSum == Integer.MIN_VALUE) ? -1 : maxSum;
    }

    private int sumDigits(int n){
        int s =0;
        while (n > 0){
            s+=n%10;
            n/=10;
        }
        return s;
    }

    public int maximumSum2(int[] nums) {
        // creates a table to keep track of all the digits sums and their respective numbers the come from
        // where in the list for the numbers i will be using a pq so i can extract the two greatest numbers at the end to get the maxsum
        Hashtable<Integer, PriorityQueue<Integer>> table = new Hashtable<>();
        for (int n : nums) {
            int temp = n;
            int sn = 0;
            // finds the sum of the digits
            while (temp != 0) {
                sn += temp % 10;
                temp/=10;
            }
            // if the table already contains that sum it will update the pq and replace the older one
            if (table.containsKey(sn)) {
                PriorityQueue<Integer> pq = table.get(sn);
                pq.add(n);
                table.replace(sn, table.get(sn), pq);
            }
            // otherwise it will create the pq with Collections.reverseOrder to use it as a maxHeap
            else {
                PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
                p.add(n);
                table.put(sn, p);
            }
        }
        int maxSum = Integer.MIN_VALUE;
        // creates the map with the keys and pqs
        for (Map.Entry<Integer,PriorityQueue<Integer>> entry : table.entrySet()){
            PriorityQueue<Integer> q = entry.getValue();
            // sees if it contains at least two numbers
            if (q.size() < 2) continue;
            // get the maxSum of that sum of digits and compares it with the current maxSum
            int currentSum = q.poll() + q.poll();
            if (currentSum > maxSum) maxSum = currentSum;
        }
        return (maxSum == Integer.MIN_VALUE) ? -1 : maxSum;
    }
    public static void main(String[] args) {
        int[] s = {18,43,36,13,7};
        ex2342 myo = new ex2342();
        myo.maximumSum(s);
    }
}