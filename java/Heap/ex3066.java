import java.util.PriorityQueue;

public class ex3066 {
    public int minOperations(int[] nums, int k) {
        // creates a minHeap as long to avoid overflow
        PriorityQueue<Long> pq = new PriorityQueue<>();
        // count operations
        int operations = 0;
        // fill the heap
        for (int n : nums){
            pq.add((long)n);
        }
        // needs to be size >= 2 and the min element lower than k
        while (pq.size() >= 2 && pq.peek() < k) {
            operations++;
            long fir = pq.poll();
            long sec = pq.poll();
            // uses the formula to add
            pq.add(Math.min(fir,sec) * 2 + Math.max(fir, sec));
        }
        return operations;
    }
    public static void main(String[] args) {
        int[] ns ={1000000000,999999999,1000000000,999999999,1000000000,999999999};
        ex3066 myo = new ex3066();
        myo.minOperations(ns, 1000000000);

    }
}
 