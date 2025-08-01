class ex2145{
    /**
     * Calculates the number of valid arrays that can be constructed given
     * the differences array such that all elements in the resulting array
     * are within the specified bounds [lower, upper].
     * Approach:
     * 1. Compute the prefix sums of the differences to understand the
     * relative values from the start.
     * 2. Track the minimum and maximum values of these prefix sums.
     * 3. Determine the valid range for the start value based on the prefix
     * sums and bounds.
     * 4. Calculate the count of possible start values that can generate
     * valid arrays within bounds.
     *
     * Time Complexity: O(n), where n is the length of the differences array.
     * Space Complexity: O(1), using only a few integer variables.
     *
     * @param differences array representing the differences between consecutive elements
     * @param lower the lower bound for values in the resulting array
     * @param upper the upper bound for values in the resulting array
     * @return the count of valid arrays that satisfy the given constraints
     */
    public int numberOfArrays(int[] differences, int lower, int upper) {
            int minPrefix = 0;
            int maxPrefix = 0;
            int prefix = 0;
    
            for (int diff : differences){
                prefix += diff;
                minPrefix = Math.min(minPrefix, prefix);
                maxPrefix = Math.max(maxPrefix, prefix);
                if (maxPrefix - minPrefix > upper - lower) {
                    return 0;
                }
            }
    
            int startLower = lower - minPrefix;
            int startUpper = upper - maxPrefix;
            int answer = Math.max(0, startUpper - startLower + 1);
            return answer;
        }
}