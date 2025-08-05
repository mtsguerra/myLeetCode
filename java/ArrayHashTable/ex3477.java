import java.util.*;

class ex3477{
    /*
     * Given an array of integers fruits representing the types of fruits in a basket, and an array of integers baskets representing the maximum capacity of each basket, return the number of fruits that cannot be placed in any basket.
     *
     * Time Complexity: O(n * m), where n is the number of fruits and m is the number of baskets.
     * Space Complexity: O(1), since we are not using any additional data structures that grow with input size.
     *
     * @param fruits Array of integers representing types of fruits
     * @param baskets Array of integers representing capacities of baskets
     * @return Number of unplaced fruits
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int answer = 0;
        for (int fruit: fruits) {
            boolean found=false;
            for (int i=0; i<baskets.length; i++) {
                if (fruit <= baskets[i]) {
                    baskets[i] = 0;
                    found = true;
                    break;
                }
            }
            if (!found) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        ex3477 solution = new ex3477();
        int [] fruits = {3,6,1};
        int  [] baskets = {6,4,7};
        int numOfUnplacedFruits = solution.numOfUnplacedFruits(fruits, baskets);
    }
}