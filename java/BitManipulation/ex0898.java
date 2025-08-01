import java.util.*;

class ex0898 {

    /**
     * Given an array of integers arr, return the number of distinct bitwise OR results
     * of all non-empty subarrays of arr.
     * Approach:
     * This solution uses a HashSet to keep track of distinct bitwise OR results.
     * It iterates through the array in reverse order, maintaining a set of
     * only the distinct bitwise OR results of the last processed index.
     *
     * Time Complexity: O(n^2) in the worst case, but optimized to O(n) on average.
     * Space Complexity: O(n) for storing distinct results.
     *
     * @param arr Array of integers
     * @return Number of distinct bitwise OR results
     */
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();
        for (int i=arr.length-1; i>=0; i--) {
            HashSet<Integer> tmp = new HashSet<>();
            tmp.add(arr[i]);
            for (int j : prev) {
                tmp.add(j | arr[i]);
            }
            prev = tmp;
            set.addAll(prev);
        }
        return set.size();
    }
}