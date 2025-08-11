import java.util.*;

class ex3479{
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        TreeMap<Integer, Queue<Integer>> map = new TreeMap<>();
        for (int i = 0; i < baskets.length; i++) {
            map.computeIfAbsent(baskets[i], k -> new LinkedList<>()).offer(i);
        }
        int answer = 0;
        int lowestIndexAvailable = 0;
        Set<Integer> set = new HashSet<>();
        for (int fruit : fruits) {
            Integer ceiling = map.ceilingKey(fruit);
            if (ceiling == null){
                answer++;
                continue;
            }
            int bestIndex = Integer.MAX_VALUE;
            int bestBasket = -1;
            for (Map.Entry<Integer, Queue<Integer>> entry : map.tailMap(ceiling,
                    true).entrySet()) {
                Queue<Integer> queue = entry.getValue();
                if (!queue.isEmpty() && queue.peek() < bestIndex) {
                    bestIndex = queue.peek();
                    bestBasket = entry.getKey();
                    if (bestIndex == lowestIndexAvailable) {
                        break;
                    }
                }
            }
            if (bestBasket == -1) answer++;
            else {
                set.add(bestIndex);
                if (bestIndex == lowestIndexAvailable) {
                    for (int i=lowestIndexAvailable; i < baskets.length; i++) {
                        if (!set.contains(i)) {
                            lowestIndexAvailable = i;
                            break;
                        }
                    }
                }
                map.get(bestBasket).poll();
                if (map.get(bestBasket).isEmpty()) {
                    map.remove(bestBasket);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ex3479 solution = new ex3479();
        int[] fruits = {4,2,5};
        int[] baskets = {3,5,4};
        int numOfUnplacedFruits = solution.numOfUnplacedFruits(fruits, baskets);
        System.out.println(numOfUnplacedFruits); // Output: 0
    }
}