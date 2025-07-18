import java.util.*;
import java.util.stream.Collectors;

class ex0347{
    
    public int[] topKFrequent2 (int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> map.get(a)-map.get(b)
        );

        for (int n : map.keySet()){
            pq.offer(n);
            if (pq.size()>k){
                pq.poll();
            }
        }

        int[] ans = new int[k];
        for (int i=0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;

    }
    
    // using stream to count the number of each element in the array
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        // stream nums
        HashMap<Integer, Long> ic = (HashMap<Integer, Long>) Arrays.stream(nums)
                // turns into Integer
                .boxed()
                // grouping by the number and counting the number of each element
                .collect(Collectors.groupingBy(
                        number -> number,
                        Collectors.counting()));
        for (int i=0;i<k;i++){
            // finds the maxCount
            Long max = Collections.max(ic.values());
            // finds the keys with the maxCount
            List<Integer> keysWithMaxValue = ic.entrySet().stream()
                    .filter (entry -> entry.getValue()==max)
                    .map (Map.Entry::getKey)
                    .collect(Collectors.toList());
            while (!keysWithMaxValue.isEmpty() && i < k){
                int crr = keysWithMaxValue.remove(0);
                ans[i++] = crr;
                ic.remove(crr);
            }
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {
        ex0347 ex = new ex0347();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] ans = ex.topKFrequent(nums, k);
        for (int i : ans){
            System.out.print(i + " ");
        }
    }
}