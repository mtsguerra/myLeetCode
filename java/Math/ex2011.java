import java.util.*;

class ex2011{
    /**
     * This method computes the final value of a variable after performing a series of operations.
     * Each operation is represented as a string in the input array, where "++X" or "X++" increments
     * the variable by 1, and "--X" or "X--" decrements the variable by 1.
     *
     * Time Complexity: O(n), where n is the number of operations.
     * Space Complexity: O(1), as we are using a constant amount of extra space.
     *
     * @param operations An array of strings representing the operations to be performed.
     * @return The final value of the variable after all operations have been executed.
     */
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }
}