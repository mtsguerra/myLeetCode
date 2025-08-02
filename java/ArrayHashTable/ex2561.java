import java.util.*;

class ex2561{

    /**
     * Given two baskets of fruits represented by two integer arrays basket1
     * and basket2,this method calculates the minimum cost to make the two
     * baskets equal. The cost is defined as the sum of the minimum of each
     * pair of exchanged fruits. If it's not possible to make the baskets
     * equal, it returns -1.
     *
     * Time Complexity: O(n log n) where n is the total number of fruits in both baskets.
     * Space Complexity: O(n) for storing excess fruits.
     *
     * @param basket1 First basket of fruits
     * @param basket2 Second basket of fruits
     * @return Minimum cost to make the two baskets equal or -1 if not possible
     */
    public long minCost(int[] basket1, int[] basket2) {
        long cost = 0;
        int minGlobal = Integer.MAX_VALUE;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : basket1) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            minGlobal = Math.min(minGlobal, num);
        }
        for (int num : basket2) {
            count.put(num, count.getOrDefault(num, 0) - 1);
            minGlobal = Math.min(minGlobal, num);
        }
        List<Integer> excessList = new ArrayList<>();
        for (int key : count.keySet()) {
            if (count.get(key) % 2 != 0) {
                return -1;
            }
            for (int i = 0; i < Math.abs(count.get(key)) / 2; i++) {
                excessList.add(key);
            }
        }
        Collections.sort(excessList);
        for (int i = 0; i < excessList.size() / 2; i++) {
            cost += Math.min(excessList.get(i),minGlobal*2);
        }
        return cost;
    }

    /*
    // My first attempt, but there's a better one
    public long minCost(int[] basket1, int[] basket2) {
        long cost = 0;
        int minGlobal = Integer.MAX_VALUE;
        Map<Integer, Integer> countMap1 = new HashMap<>();
        Map<Integer, Integer> countMap2 = new HashMap<>();
        Map<Integer, Integer> countAll = new HashMap<>();
        for (int num : basket1) {
            countMap1.put(num, countMap1.getOrDefault(num, 0) + 1);
            countAll.put(num, countAll.getOrDefault(num, 0) + 1);
            minGlobal = Math.min(minGlobal, num);
        }
        for (int num : basket2) {
            countMap2.put(num, countMap2.getOrDefault(num, 0) + 1);
            countAll.put(num, countAll.getOrDefault(num, 0) + 1);
            minGlobal = Math.min(minGlobal, num);
        }
        for (Map.Entry<Integer, Integer> entry : countAll.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return -1;
            }
        }
        List<Integer> excessList1 = new ArrayList<>();
        List<Integer> excessList2 = new ArrayList<>();
        int inbalance = 0;
        for (int fruit : countAll.keySet()) {
            int ideal = countAll.get(fruit) / 2;
            int count1 = countMap1.getOrDefault(fruit, 0);
            int count2 = countMap2.getOrDefault(fruit, 0);
            if (count1 == count2) continue;
            if (count1 > ideal) {
                int excess = count1 - ideal;
                inbalance += excess;
                for (int i = 0; i < excess; i++) {
                    excessList1.add(fruit);
                }
            }
            else if (count2 > ideal) {
                int excess = count2 - ideal;
                for (int i = 0; i < excess; i++) {
                    excessList2.add(fruit);
                }
            }
        }
        Collections.sort(excessList1);
        Collections.sort(excessList2);
        int start1 = 0, start2 = 0;
        for (int i = 0; i < inbalance; i++) {
            int fruit1 = excessList1.get(start1);
            int fruit2 = excessList2.get(start2);
            int tradeCoin;
            if (fruit1 <= fruit2) {
                tradeCoin = fruit1;
                start1++;
            }
            else{
                tradeCoin = fruit2;
                start2++;
            }
            if (tradeCoin > minGlobal*2) {
                tradeCoin = minGlobal*2;
            }
            cost += tradeCoin;
        }
        return cost;
    }*/

    public static void main(String[] args) {
        ex2561 myo = new ex2561();
        int[] basket1 = {84,80,43,8,80,88,43,14,100,88};
        int[] basket2 = {32,32,42,68,68,100,42,84,14,8};
        long result = myo.minCost(basket1, basket2);
        System.out.println("Minimum cost: " + result);
    }
}