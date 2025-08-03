import java.util.*;

class ex2106{

    /**
     * Given an array of fruits where fruits[i] = [position i, count i], the
     * position of the ith fruit and the number of fruits at that position, a
     * starting position startPos, and an integer k representing the maximum
     * distance you can travel, return the maximum number of fruits you can collect.
     *
     * Time Complexity: O(n), where n is the number of elements in the fruits array.
     * Space Complexity: O(1), since we are using a constant amount of space for variables.
     *
     * @param fruits 2D array representing positions and counts of fruits
     * @param startPos Starting position
     * @param k Maximum distance you can travel
     * @return Maximum number of fruits that can be collected
     */
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int maxFruits = 0;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < fruits.length; right++) {
            sum += fruits[right][1];
            while (left <= right){
                int leftPosition = fruits[left][0];
                int rightPosition = fruits[right][0];
                int totalDistance =
                        (rightPosition - leftPosition) + Math.min(Math.abs(leftPosition - startPos), Math.abs(rightPosition - startPos));
                if (totalDistance > k) {
                    sum -= fruits[left][1];
                    left++;
                }
                else break;
            }
            maxFruits = Math.max(maxFruits, sum);
        }
        return maxFruits;
    }

    /*
    // My totally solo attempt at solving this problem without sliding window.
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int maxFruits = 0;

        int leftSum = 0;
        int rightSum = 0;
        int startingFruits = 0;

        List<int[]> leftSteps = new ArrayList<>();
        List<int[]> rightSteps = new ArrayList<>();

        for (int[] fruit : fruits) {
            int position = fruit[0];
            int count = fruit[1];
            if (count == 0) continue;
            if (position < startPos && startPos - position <= k) {
                leftSum += count;
                int[] pair = new int[] {startPos-position, count};
                leftSteps.add(pair);
            }
            else if (position > startPos && position - startPos <= k) {
                rightSum += count;
                int[] pair = new int[] {position-startPos, count};
                rightSteps.add(pair);
            }
            else if (position == startPos) {
                startingFruits += count;
            }
        }
        maxFruits = Math.max(leftSum, rightSum);
        Collections.reverse(leftSteps);
        Stack<int[]> stack = new Stack<>();
        int accumulatedLeft = 0;
        int accumulatedRight = 0;
        for (int i = 0; i < leftSteps.size(); i++) {
            int[] left = leftSteps.get(i);
            int leftDistance = left[0];
            int leftCount = left[1];
            accumulatedLeft += leftCount;
            if (stack.isEmpty()){
                if (i > 0) break;
                for (int[] right : rightSteps) {
                    int rightDistance = right[0];
                    int rightCount = right[1];
                    int totalDistance =
                            leftDistance + rightDistance + Math.min(leftDistance,
                                    rightDistance);
                    if (totalDistance <= k) {
                        accumulatedRight += rightCount;
                        maxFruits = Math.max(maxFruits, accumulatedLeft + accumulatedRight);
                        stack.push(new int[]{rightDistance, rightCount});
                    }
                    else break;
                }
            }
            else{
                while (!stack.isEmpty() && stack.peek()[0] + leftDistance + Math.min(stack.peek()[0], leftDistance) > k) {
                    accumulatedRight -= stack.pop()[1];
                }
                maxFruits = Math.max(maxFruits, accumulatedLeft+ accumulatedRight);
            }
        }
        return maxFruits+ startingFruits;
    }*/

    public static void main(String[] args) {
        ex2106 myo = new ex2106();
        int[][] fruits = {{0, 7}, {7, 4}, {9, 10}, {12, 6}, {14, 8},
                {16, 5}, {17, 8}, {19, 4}, {20, 1}, {21, 3},
                {24, 3}, {25, 3}, {26, 1}, {28, 10}, {30, 9},
                {31, 6}, {32, 1}, {37, 5}, {40, 9}
        };
        int startPos = 21;
        int k = 30;
        int result = myo.maxTotalFruits(fruits, startPos, k);
        System.out.println("Maximum total fruits collected: " + result);
    }
}