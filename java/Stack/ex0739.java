import java.util.*;

class ex0739{
    /**
     * Given an array of integers temperatures represents the daily temperatures,
     * return an array answer such that answer[i] is the number of days you
     * have to wait after the ith day to get a warmer temperature. If there
     * is no future day for which this is possible, keep answer[i] == 0 instead.
     * This problem can be solved using a monotonic stack.
     *
     * Time Complexity: O(n) where n is the length of the temperatures array.
     * Space Complexity: O(n) for the stack used to store indices and temperatures.
     *
     * @param temperatures Array of daily temperatures
     * @return Array of days to wait for a warmer temperature
     */
    public int[] dailyTemperatures(int[] temperatures) {

        // [temp, index]
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {temperatures[temperatures.length-1],
                temperatures.length-1});

        int[] result = new int[temperatures.length];

        for (int i=temperatures.length-2; i>=0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= stack.peek()[0]) {
                stack.pop();
            }
            if (!stack.isEmpty()) result[i] = stack.peek()[1]-i;
            stack.push(new int[] {temperatures[i],i});
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
        ex0739 myo = new ex0739();
        int[] result = myo.dailyTemperatures(temperatures);
        System.out.println("Result: " + Arrays.toString(result));
    }
}