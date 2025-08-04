import java.util.*;

class ex0904{
    /**
     * Given an array of integers fruits where fruits[i] is the type of fruit
     * at index i, return the maximum number of fruits you can pick.
     * You may pick fruits in any order, but you can only pick two types of fruits.
     *
     * Time Complexity: O(n) where n is the length of the array.
     * Space Complexity: O(1) for the sliding window and O(2) for the HashMap.
     *
     * @param fruits Array of integers representing types of fruits
     * @return Maximum number of fruits that can be picked
     */
    public int totalFruit(int[] fruits) {
        int maxFruits = 1;
        int left= 0;
        // fruit : last appearance index
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(fruits[0],0);
        for (int right = 1; right < fruits.length; right++) {
            if (map.containsKey(fruits[right])) {
                map.put(fruits[right], right);
            }
            else if (map.size() < 2) {
                map.put(fruits[right], right);
            }
            else {
                int lastOne = fruits[right-1];
                // only two
                for (int key : map.keySet()) {
                    if (key != lastOne){
                        left = map.get(key) + 1;
                        map.remove(key);
                        break;
                    }
                }
                map.put(fruits[right], right);
            }
            maxFruits = Math.max(maxFruits, right - left+1);
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        ex0904 myo = new ex0904();
        int[] fruits = {0,1,1,4,3};
        System.out.println(myo.totalFruit(fruits)); // Output: 3
        fruits = new int[]{0,1,2,2};
        System.out.println(myo.totalFruit(fruits)); // Output: 3
        fruits = new int[]{1,2,3,2,2};
        System.out.println(myo.totalFruit(fruits)); // Output: 4
    }

}